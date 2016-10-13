package voxSpell.quiz;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import voxSpell.GUI.QuizScreen;
import voxSpell.achievements.Achievement;
import voxSpell.achievements.AchievementList;
/**
 * Abstract class representing the quiz format (extended to represent NewQuiz and Review), with 
 * quiz length of up to 10 words
 * 
 * Taken from Softeng 206 Assignment 2 submission by Aimee Tagle
 * 
 * @author atag549
 * Last Modified: 22 September, 2016
 */
public abstract class Quiz{
	
	protected String _name;
	protected int _score;
	protected boolean _isReview = false;
	protected ArrayList<String> _wordlist = null;
	protected JButton _submit = null;
	protected int _attemptNumber;
	protected int _wordNumberInt;
	protected QuizScreen _screen;
	protected ArrayList<Boolean> _originalAchievements;
	private ArrayList<Achievement> _newAchievements;
	private ExecutorService _threadPool;

	public Quiz(QuizScreen screen, boolean isReview){
		_originalAchievements = AchievementList.getInstance().getShallowCopy();
		_threadPool = Executors.newFixedThreadPool(1);
		_wordNumberInt = 1;
		_attemptNumber = 1;
		_screen = screen;
		_isReview = isReview;
		//check which list to get words from
		if(_isReview){
			_wordlist = Lists.getInstance().getLastFailed().returnTestlist();
		}else{
			_wordlist = Lists.getInstance().getWordList(Settings.getInstance().getLevel()).returnTestlist();
		}
	}
	/**
	 * Compares the spelling given by the user with the current word to spell in the quiz
	 * @param rawSpelling
	 */
	public final void checkSpelling(String rawSpelling){
		if( rawSpelling.trim().equals("") == false){
			//make trim string
			String spelling = rawSpelling.trim().toLowerCase();
			if(containsInvalidCharacters(spelling) == false){
				//first attempts
				try{
					if(_attemptNumber == 1){
						if(spelling.equals(_wordlist.get(_wordNumberInt-1).toLowerCase())){
							Lists.getInstance().getMastered().addWord(_wordlist.get(_wordNumberInt-1));
							if(Lists.getInstance().getLastFailed().contains(_wordlist.get(_wordNumberInt-1))){
								Lists.getInstance().getLastFailed().remove(_wordlist.get(_wordNumberInt-1));
							}
							_wordNumberInt++;
							_score++;
							rightSound();
							//Update the streak
							Lists.getInstance().increaseStreak();
						} else{
							_attemptNumber++;
							Lists.getInstance().resetStreak();
							wrongSound();
						}
						quizQuestion();
						//Second attempt- failed or faulted
					} else if (_attemptNumber == 2){
						if(spelling.equals(_wordlist.get(_wordNumberInt-1).toLowerCase())){
							rightSound();
							Lists.getInstance().getFaulted().addWord(_wordlist.get(_wordNumberInt-1));
							if(Lists.getInstance().getLastFailed().contains(_wordlist.get(_wordNumberInt-1))){
								Lists.getInstance().getLastFailed().remove(_wordlist.get(_wordNumberInt-1));
							}
							_attemptNumber = 1;
							_wordNumberInt++;
							updateWordNumberInGUI();
							quizQuestion();
						} else{
							wrongSound();
							Lists.getInstance().getFailed().addWord(_wordlist.get(_wordNumberInt-1));
							if(Lists.getInstance().getLastFailed().contains(_wordlist.get(_wordNumberInt-1))==false){
								Lists.getInstance().getLastFailed().addWord(_wordlist.get(_wordNumberInt-1));
							}
							spellAloud(_wordlist.get(_wordNumberInt-1));
						}
						//Third attempt for review - no change to word status
					} else{
						if(spelling.equals(_wordlist.get(_wordNumberInt-1).toLowerCase())){
							sayPhrase("Correct.");
						} else{
							sayPhrase("Incorrect.");
						}
						_attemptNumber = 1;
						_wordNumberInt++;
						updateWordNumberInGUI();
						quizQuestion();
					}
				} catch (Exception e){

				}
			}else {
				JOptionPane.showMessageDialog(null, "Only alphabetical characters (a-z/A-Z) and apostrophes may be used for spelling.", "Review", JOptionPane.ERROR_MESSAGE);
			}

		} 
	}
	public final void quizQuestion(){
		//Only quiz if there are words left to quiz
		if(_wordNumberInt< _wordlist.size()+1){
			try {
				sayWord();

				if (_attemptNumber == 1){
					updateWordNumberInGUI();
					_screen.updateScore(_score);
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error saying word", "Quiz Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			endQuiz();
		}
	}

	protected void updateWordNumberInGUI(){
		_screen.updateWordNumber(_wordNumberInt, _wordlist.size()); 
	}

	//Returns true if string has characters which are not letters
	protected final boolean containsInvalidCharacters(String word){
		char[] wordArray = word.trim().toCharArray();
		for	(char i : wordArray){
			if((i < 'a' || i > 'z')&&(i!='\'')){
				return true;
			}
		}
		return false;
	}
	
	protected void endQuiz(){
		_newAchievements = AchievementList.getInstance().checkChange(_originalAchievements);
		_screen.endQuiz();
	}
	
	protected void sayPhrase(String phrase){
		SayAnything anything = new SayAnything(phrase, _screen);
		_screen.disableButtons();
		_threadPool.execute(anything);
	}
	
	public int getScore(){
		return _score;
	}
	
	public ArrayList<Achievement> getNewAchievements(){
		return _newAchievements;
	}
	
	public void sayWord(){
		_screen.disableButtons();
		_threadPool.execute(new SayAnything(_wordlist.get(_wordNumberInt-1),_screen, true));
	}
	
	private void rightSound(){
		sayPhrase("Correct");
	}
	
	protected void wrongSound(){
		sayPhrase("Incorrect. Please try again.");
	}
	
	public void exit(){
		Lists.getInstance().resetStreak();
	}
	/*
	 * Hook method for spelling aloud implementation
	 */
	protected abstract void spellAloud(String word);

	public int getNumberOfWords(){
		return _wordlist.size();
	}


}