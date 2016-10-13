package voxSpell.quiz;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

import javax.swing.SwingWorker;

import voxSpell.GUI.QuizScreen;

/**
 * Swingworker class in responsible for making Festival calls to say words aloud via .scm files.
 * 
 * Taken from Softeng 206 Assignment 2 submission by Aimee Tagle (originally an inner class)
 * @author osboxes
 * Last Modified: 21 September, 2016
 */
class SayAnything extends SwingWorker<Void, Void>{
	private boolean _done = false;
	private String _phrase = null;
	private String _fileName = "/.say.scm";
	QuizScreen _screen = null;
	Process _process;
	
	/**
	 * Constructor for general phrase
	 * @param anything
	 * @param screen
	 */
	public SayAnything(String anything, QuizScreen screen){
		_phrase = anything;
		_screen  = screen;
		//Create the .scm file
		PrintWriter writer;
		_phrase = anything;
		try {
			writer = new PrintWriter(Lists.PATH +_fileName);
			writer.println("(voice_" + Settings.getInstance().getVoice() + ") ;;");
			writer.println("(SayText \"" + _phrase + "\")");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 	 * If the phrase being said is a word, use a different .scm file
	 */
	public SayAnything(String anything, QuizScreen screen, boolean isWord){
		_screen  = screen;
		if(isWord){
			_fileName = "/.word.scm";
		}
		PrintWriter writer;
		_phrase = anything;
		try {
			writer = new PrintWriter(Lists.PATH +_fileName);
			writer.println("(voice_" + Settings.getInstance().getVoice() + ") ;;");
			writer.println("(SayText \"" + _phrase + "\")");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected Void doInBackground(){
		ProcessBuilder sayBuilder = new ProcessBuilder("/bin/bash", "-c", "festival -b " + Lists.PATH + _fileName);
		try {
			_process = sayBuilder.start();
			_process.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	protected void done(){
		if(_screen != null){
			_screen.enableButtons();
		}
	}

	protected void setPhrase(String phrase){
		_phrase = phrase;
	}
}