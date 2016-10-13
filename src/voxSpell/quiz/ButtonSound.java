package voxSpell.quiz;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingWorker;

import voxSpell.GUI.GUI;


public class ButtonSound extends SwingWorker<Void, Void>{
	private static final String SOUND = "/Sound/";
	private String _soundName;
	
	public ButtonSound(String soundName){
		_soundName = soundName;
	}
	@Override
	protected Void doInBackground() throws Exception {
		/*AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Lists.PATH+SOUND+_soundName).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		//from http://stackoverflow.com/questions/2335601/reliably-playing-a-short-sound-in-java

	    while (System.in.read() == '\n') {
	        clip.stop();
	        clip.setFramePosition(0);
	        clip.start();
	    }*/
		
		File soundFile = new File(GUI.PATH + SOUND + _soundName);
		Clip clip = AudioSystem.getClip();
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile.getAbsoluteFile());
		clip.open(inputStream);
	    clip.start();
		return null;
	}

}
