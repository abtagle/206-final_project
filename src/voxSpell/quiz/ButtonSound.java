package voxSpell.quiz;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingWorker;

import voxSpell.GUI.GUI;

/**
 * Class representing the sound that sounds when main meny buttons are pressed
 * @author atag549
 * Last Modified: 21 October, 2016
 */
public class ButtonSound extends SwingWorker<Void, Void>{
	private static final String SOUND = "/Sound/";
	private String _soundName;
	
	public ButtonSound(String soundName){
		_soundName = soundName;
	}
	/**
	 * swingworker method to prevent GUI freezing when the sound plays
	 */
	@Override
	protected Void doInBackground() throws Exception {
		File soundFile = new File(GUI.PATH + SOUND + _soundName);
		Clip clip = AudioSystem.getClip();
		AudioInputStream inputStream = AudioSystem.getAudioInputStream(soundFile.getAbsoluteFile());
		clip.open(inputStream);
	    clip.start();
		return null;
	}

}
