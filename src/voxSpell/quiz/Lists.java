package voxSpell.quiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import javax.swing.JOptionPane;

import voxSpell.GUI.GUI;
import voxSpell.achievements.AchievementList;

/**
 * Class representing an almost database of all the lists of words used, allowing access to all of them throughout
 * the voxSpell.gui package
 * Taken from Softeng 206 Assignment 2 submission by Aimee Tagle
 * @author atag549
 * Last Modified: 14 October, 2016
 *
 */

public class Lists {
	public static final String PATH = new File(System.getProperty("java.class.path")).getAbsoluteFile().getParentFile().toString() + "/.media";
	public static final String MASTERED = PATH+"/.mastered"; //path to mastered list
	public static final String FAULTED = PATH+"/.faulted"; //path to faulted list
	public static final String FAILED = PATH+"/.failed"; //path to failed list
	public static final String LAST_FAILED = PATH+"/.lastFailed"; //path to the words last failed that should be in review for filed words
	public static final String STREAK_VALUES = PATH+"/.streak"; //path to file storing streaks and words done
	public static final String LEVEL_STATS= PATH+"/.stats";//path to file storing individual level stats
	private HashMap<String, WordList> _wordLists = null; //HashMap storing ALL lists with their name as a key
	private WordList _mastered;
	private WordList _faulted;
	private WordList _failed;
	private WordList _lastFailed;
	private int _longestStreak;
	private int _currentStreak;
	private int _numberOfWordsRight;
	private int _numberOfWordsAttempted;
	private HashMap<String, LevelStats> _levelStats;
	private static Lists _thisList = null;

	private Lists(){
		//Reads in all the statistics storing lists if they already  exist
		AchievementList.getInstance();

		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		_thisList = this;

		_mastered = new WordList();
		_faulted =  new WordList();
		_failed =  new WordList();
		_lastFailed =  new WordList();

		readInLevelStats();
		readInStreaks();
		_mastered = readInFile(MASTERED);
		_faulted = readInFile(FAULTED);
		_failed = readInFile(FAILED);
		_lastFailed = readInFile(LAST_FAILED);
	}
/**
 * returns instance of singleton Lists class
 * @return
 */
	public static Lists getInstance(){
		if (_thisList == null){
			_thisList =  new Lists();
		} 
		return _thisList;
	}
	/**
	 * Reads in streaks from the streak file and stores the information in the related variables and objects
	 */
	private void readInStreaks(){
		//Read in order: Longest streak, current streak, number of words right
		File streakValues = new File(STREAK_VALUES);
		if(streakValues.exists()){
			try{
				BufferedReader streakValuesReader = new BufferedReader(new FileReader(streakValues));
				String line = streakValuesReader.readLine();
				String[] split = line.split("\\s+");
				_longestStreak = Integer.parseInt(split[0]);
				_currentStreak = Integer.parseInt(split[1]);
				_numberOfWordsRight = Integer.parseInt(split[2]);
				_numberOfWordsAttempted = Integer.parseInt(split[3]);
				streakValuesReader.close();	

			} catch (FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Error: unable to load " + STREAK_VALUES + ".");

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: unable to read from word list " + STREAK_VALUES + ".");
			}
		}else{
			_longestStreak = 0;
			_currentStreak = 0;
			_numberOfWordsRight = 0;
			_numberOfWordsAttempted = 0;
		}
	}
	/**
	 * Reads in streaks from the level stats file and stores the information in the related variables and objects
	 */
	private void readInLevelStats(){
		//Read in order: Longest streak, current streak, number of words right
		_levelStats = new HashMap<String, LevelStats>();
		File levelStats = new File(LEVEL_STATS);
		if(levelStats.exists()){
			try{
				BufferedReader statsRead = new BufferedReader(new FileReader(levelStats));
				String stat;
				String listName = "";

				while((stat = statsRead.readLine()) != null){
					listName = stat;
					String details = statsRead.readLine();
					String[] split  = details.split("\\s+");
					_levelStats.put(listName, new LevelStats(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
				}
				statsRead.close();	
			} catch (FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Error: unable to load " + STREAK_VALUES + ".");

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: unable to read from word list " + STREAK_VALUES + ".");
			}
		} 
	}
	/**
	 * method for reading files which are word lists
	 * @param filename name of the file you want to read in
	 * @return
	 */
	private WordList readInFile(String filename){
		WordList words = new WordList();
		File wordList = new File(filename);
		if(wordList.exists()){
			try{
				BufferedReader wordListRead = new BufferedReader(new FileReader(wordList));
				String word;
				while((word = wordListRead.readLine()) != null){
					if((word.equals("") == false && (word.equals("\\s+") == false))){
						words.addWord(word);
					}
				}
				wordListRead.close();	
				Collections.sort(words.returnArrayList(), String.CASE_INSENSITIVE_ORDER);

			} catch (FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Error: unable to load " + filename + ".");

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: unable to read from word list " + filename + ".");
			}
		}
		return words;
	}
	/**
	 * Reads in the wordlist file specified by the user
	 * @param file
	 */
	public void setWordList(File file){
		if(file.exists()){
			try{
				BufferedReader checkReader = new BufferedReader(new FileReader(file));
				if(checkReader.readLine().charAt(0)=='%'){
					_wordLists = new HashMap<String, WordList>();
					BufferedReader wordListRead = new BufferedReader(new FileReader(file));
					String word;
					String listName = "";

					while((word = wordListRead.readLine()) != null){
						if((word.equals("") == false && (word.equals("\\s+") == false)&& word.charAt(0)!='%')){
							_wordLists.get(listName).addWord(word);
						} else if( word.charAt(0)=='%'){
							listName = word.substring(1);
							_wordLists.put(listName, new WordList());
						}
					}
					wordListRead.close();	
				} else{
					JOptionPane.showMessageDialog(null, "Error: file  " + file.getName() + " is not in correct format.");
				}
				checkReader.close();

			} catch (FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Error: unable to load " + file.getName() + ".");

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: unable to read from word list " + file.getName() + ".");
			}
		}
	}
/**
 * Increases the value of the current streak when a word is spelt correctly
 */
	protected void increaseStreak(){
		_currentStreak++;
		_numberOfWordsRight++;
		_numberOfWordsAttempted++;
		if(_currentStreak > _longestStreak){
			_longestStreak = _currentStreak;
		}
		if(_levelStats.containsKey(Settings.getInstance().getLevel())){
			_levelStats.get(Settings.getInstance().getLevel()).update(true);
		} else{
			//Make new LevelStats if no stats exist
			_levelStats.put(Settings.getInstance().getLevel(), new LevelStats(1,1));
		}
	}
/**
 * Resets the counter on the streak when a word is spelt incorrectly, ot if the quiz is interrupted other than by closing
 */
	protected void resetStreak(){
		_numberOfWordsAttempted++;
		_currentStreak = 0;
		if(_levelStats.containsKey(Settings.getInstance().getLevel())){
			_levelStats.get(Settings.getInstance().getLevel()).update(false);
		} else{
			//Make new LevelStats if no stats exist
			_levelStats.put(Settings.getInstance().getLevel(), new LevelStats(1,0));
		}

	}

/**
 * Returns the wordlist for the given parameter level
 * @param level
 * @return
 */
	public WordList getWordList(String level){
		return _wordLists.get(level);
	}
	/**
	 * Returns an arraylist of all the names of wordlists loaded into the system
	 * @return
	 */
	public ArrayList<String> getListNames(){
		ArrayList<String> names = new ArrayList<String>();
		for(String i : _wordLists.keySet()){
			names.add(i);
		}
		Collections.sort(names);
		return names;
	}
	
	//Various getters for mainly primitives below
	public int getLongestStreak(){
		return _longestStreak;
	}
	public int getStreak(){
		return _currentStreak;
	}
	public int getWordsRight(){
		return _numberOfWordsRight;
	}
	public int getWordsAttempted(){
		return _numberOfWordsAttempted;
	}
	public WordList getMastered(){
		return _mastered;
	}
	public WordList getFaulted(){
		return _faulted;
	}
	public WordList getFailed(){
		return _failed;
	}
	public WordList getLastFailed(){
		return _lastFailed;
	}
	public double getAccuracy(String level){
		return _levelStats.get(level).getAccuracy();
	}
	public double getAccuracy(){
		if(_numberOfWordsAttempted == 0){
			return 0;
		}
		return (double)(_numberOfWordsRight*100/_numberOfWordsAttempted);
	}
	public int getWordsTested(String level){
		return _levelStats.get(level).getNumberOfWordsTested();
	}
	public ArrayList<String> getLevelsWithStats(){
		if(_levelStats.keySet().isEmpty()){
			return new ArrayList<String>();
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.addAll(_levelStats.keySet());
		return arrayList;

	}
	public int getNumberOfLevels(){

		return _wordLists.size();
	}
	
	/**
	 * Erases the stats by reintantiating all the objects storing the stats
	 */
	public void clearStats(){
		_mastered = new WordList();
		_faulted = new WordList();
		_failed = new WordList();
		_lastFailed = new WordList();
		_currentStreak = 0;
		_longestStreak = 0;
		_numberOfWordsRight = 0;
		_numberOfWordsAttempted = 0;
		_levelStats = new HashMap<String, LevelStats>();
	}
	/**
	 * Writes all statistics records to files for storage for the next session
	 */
	public void writeAllStats(){
		try {
			writeStreaksToFile();
			writeLevelStatsToFile();
			writeListToFiles(_mastered.returnArrayList(), MASTERED);
			writeListToFiles(_faulted.returnArrayList(), FAULTED);
			writeListToFiles(_failed.returnArrayList(), FAILED);
			writeListToFiles(_lastFailed.returnArrayList(), LAST_FAILED);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {

			e.printStackTrace();
		}
	}
	/**
	 * Helper method for writeAllStats which writes out word lists
	 * @param list
	 * @param filename
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	private void writeListToFiles(ArrayList<String> list, String filename) throws FileNotFoundException, UnsupportedEncodingException{
		//From: http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
		PrintWriter writer = new PrintWriter(filename);
		for(String i : list){
			writer.println(i);
		}
		writer.close();

	}
/**
 * Helper method of writeAllStats which writes out streak alues
 * @throws FileNotFoundException
 */
	private void writeStreaksToFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(STREAK_VALUES);
		writer.println(_longestStreak + " " + _currentStreak + " " + _numberOfWordsRight + " " +_numberOfWordsAttempted);
		writer.close();
	}
/**
 * Helper method of writeAllStats which writes out to stats values
 * @throws FileNotFoundException
 * @throws FileNotFoundException
 */
	private void writeLevelStatsToFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(LEVEL_STATS);
		for(String list : _levelStats.keySet()){
			writer.println(list);
			writer.println( _levelStats.get(list).getNumberOfWordsTested() + " "+ _levelStats.get(list).getNumberOfWordsRight());
		}
		writer.close();
	}
	/**
	 * Inner class written for this project for objects storing stats for each level, allowing easier storage
	 * Last Modified 05 October, 2016
	 * @author atag549
	 *
	 */
	private class LevelStats{
		private int _numberOfWordsRight;
		private int _numberOfWordsTested;
		public LevelStats(int numberOfWordsTested, int numnberOfWordsRight){
			_numberOfWordsRight = numnberOfWordsRight;
			_numberOfWordsTested = numberOfWordsTested;
		}
		public LevelStats(){
			this(0,0);
		}
		/**
		 * Updates the level stats depending on if the word from the level was spelt correctly
		 * @param isCorrect
		 */
		public void update(boolean isCorrect){
			_numberOfWordsTested++;
			if(isCorrect){
				_numberOfWordsRight++;
			}
		}
		/**
		 * returns level's accuracy
		 * @return
		 */
		public double getAccuracy(){
			return ((double)_numberOfWordsRight/(double)_numberOfWordsTested) * 100;
		}
		//Various self-explanatory getters
		public int getNumberOfWordsTested(){
			return _numberOfWordsTested;
		}
		public int getNumberOfWordsRight(){
			return _numberOfWordsRight;
		}
	}

}
