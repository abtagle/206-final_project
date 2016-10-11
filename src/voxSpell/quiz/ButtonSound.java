package voxSpell.quiz;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingWorker;


public class ButtonSound extends SwingWorker<Void, Void>{
	private static final String SOUND = "/Sound/";
	private String _soundName;
	
	public ButtonSound(String soundName){
		_soundName = soundName;
	}
	@Override
	protected Void doInBackground() throws Exception {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(Lists.PATH+SOUND+_soundName).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		return null;
	}

}
