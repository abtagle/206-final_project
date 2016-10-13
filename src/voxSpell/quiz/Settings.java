package voxSpell.quiz;

import java.util.HashMap;

/*
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
	public static Settings getInstance(){
		if(_settings == null){
			_settings = new Settings();
		}
		return _settings;
		
	}
	private Settings(){
		knownVoices = new HashMap<String, String>();
		knownVoices.put("kal_diphone", "US English");
		knownVoices.put("rab_diphone", "UK English");
		knownVoices.put("akl_nz_jdt_diphone", "NZ English");
		_voiceName = "kal_diphone";
		_level = Lists.getInstance().getListNames().get(0);
		_quizSize = 10;
	}
	public void setLevel(String level){
		_level = level;
	}
	public String getLevel(){
		return _level;
	}
	public void setQuizSize(int size){
		_quizSize = size;
	}
	public int getQuizSize(){
		return _quizSize;
	}
	public void setVoice(String voiceName){
		_voiceName = voiceName;		
	}
	public String alternateName(String voice){
		if(knownVoices.containsKey(voice)){
			return knownVoices.get(voice);
		} else {
			return voice;
		}
	}
	protected String getVoice(){
		return _voiceName;
	}
	public void saySampleVoicePhrase(String voiceName){
		String originalVoiceName = _voiceName;
		setVoice(voiceName);
		SayAnything sample= new SayAnything("This is the voice", null);
		sample.execute();
		setVoice(originalVoiceName);
	}
}
