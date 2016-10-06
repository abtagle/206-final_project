package voxSpell.quiz;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingWorker;

public class ButtonSound extends SwingWorker<Void, Void>{
	public static final String SOUND_NAME = "/wand.wav";
	@Override
	protected Void doInBackground() throws Exception {
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();
	
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(path+SOUND_NAME).getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		return null;
	}

}
