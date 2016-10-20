package voxSpell.quiz;

import java.util.HashMap;

/**
 * Class representing the user interface of the settings page where users can change the festival voice
 * used in quizzes
 * 
 * Class by Aimee Tagle for Assignment 3
 * Last Modified: 30 September, 2016
 * 
 */

public class Settings {
	private HashMap<String, String> knownVoices;
	static Settings _settings = null;
	private String _voiceName;
	private String _level;
	private int _quizSize;
	/**
	 * returns the singleton instance of the Settings class
	 * @return
	 */
	public static Settings getInstance(){
		if(_settings == null){
			_settings = new Settings();
		}
		return _settings;
		
	}
	/**
	 * Private singleton constructor
	 */
	private Settings(){
		knownVoices = new HashMap<String, String>();
		knownVoices.put("kal_diphone", "US English");
		knownVoices.put("rab_diphone", "UK English");
		knownVoices.put("akl_nz_jdt_diphone", "NZ English");
		_voiceName = "kal_diphone";
		_level = Lists.getInstance().getListNames().get(0);
		_quizSize = 10;
	}
	/**
	 * Sets the current level
	 * @param level
	 */
	public void setLevel(String level){
		_level = level;
	}
	/**
	 * gets the string of the current level name
	 * @return
	 */
	public String getLevel(){
		return _level;
	}
	/**
	 * Sets the size of the quiz used in New Quiz
	 * @param size
	 */
	public void setQuizSize(int size){
		_quizSize = size;
	}
	/**
	 * Returns the size of the quiz in New Quiz
	 * @return
	 */
	public int getQuizSize(){
		return _quizSize;
	}
	/**
	 * Sets the voice used for festival
	 * @param voiceName
	 */
	public void setVoice(String voiceName){
		_voiceName = voiceName;		
	}
	/**
	 * Checks if the voice is known by the system, and if it is, displays a more human-readable
	 * name for the voice
	 * @param voice
	 * @return
	 */
	public String alternateName(String voice){
		if(knownVoices.containsKey(voice)){
			return knownVoices.get(voice);
		} else {
			return voice;
		}
	}
	/**
	 * Returns the name of the voice to be used for the application
	 * @return
	 */
	protected String getVoice(){
		return _voiceName;
	}
	/**
	 * Invokes festival to say the sample phrase in the voice selected from the JComboBox before 
	 * deciding and submitting
	 * @param voiceName
	 */
	public void saySampleVoicePhrase(String voiceName){
		String originalVoiceName = _voiceName;
		setVoice(voiceName);
		SayAnything sample= new SayAnything("This is the voice", null);
		sample.execute();
		setVoice(originalVoiceName);
	}
}
