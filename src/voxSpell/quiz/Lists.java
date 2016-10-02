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

/**
 * Class representing an almost database of all the lists of words used, allowing access to all of them throughout
 * the voxSpell.gui package
 * Taken from Softeng 206 Assignment 2 submission by Aimee Tagle
 * @author atag549
 * Last Modified: 18 September, 2016
 *
 */

public class Lists {
	public static final String MASTERED = "./.mastered";
	public static final String FAULTED = "./.faulted";
	public static final String FAILED = "./.failed";
	public static final String LAST_FAILED = "./.lastFailed";
	public static final String STREAK_VALUES = "./.streak";
	public static final String WORDLIST = "/wordlist.txt";
	private HashMap<String, WordList> _wordLists = null;
	private WordList _mastered;
	private WordList _faulted;
	private WordList _failed;
	private WordList _lastFailed;
	private int _longestStreak;
	private int _currentStreak;
	private int _numberOfWordsRight;
	private int _numberOfWordsAttempted;
	private ArrayList<ArrayList<Integer>> _scores;
	private static Lists _thisList = null;

	private Lists(){
		//Reads in all the statistics storing lists if they already  exist
		_thisList = this;

		//No need to save data between sessions for assignment 3
		_mastered = new WordList();
		_faulted =  new WordList();
		_failed =  new WordList();
		_lastFailed =  new WordList();
		
		readInStreaks();
		_mastered = readInFile(MASTERED);
		_faulted = readInFile(FAULTED);
		_failed = readInFile(FAILED);
		_lastFailed = readInFile(LAST_FAILED);
		//from: stackoverflow.com/questions/15359702/get-location-of-jar-file
		File f = new File(System.getProperty("java.class.path"));
		File dir = f.getAbsoluteFile().getParentFile();
		String path = dir.toString();

		if(!path.contains(":")){
			setWordList(new File(path+WORDLIST));	
		} else{
			URL url = Lists.class.getResource(WORDLIST);
			setWordList(new File(url.getPath()));
		}
	}

	public static Lists getInstance(){
		if (_thisList == null){
			_thisList =  new Lists();
		} 
		return _thisList;
	}
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
		}
	}
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
	//Reads in the wordlist file specified by the user
	public void setWordList(File file){
		_wordLists = new HashMap<String, WordList>();
		if(file.exists()){
			
			try{
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

			} catch (FileNotFoundException e){
				JOptionPane.showMessageDialog(null, "Error: unable to load " + file.getName() + ".");

			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error: unable to read from word list " + file.getName() + ".");
			}
		}
	}

	protected void increaseStreak(){
		_currentStreak++;
		_numberOfWordsRight++;
		if(_currentStreak > _longestStreak){
			_longestStreak = _currentStreak;
		}
	}
	
	protected void resetStreak(){
		_currentStreak = 0;
	}
	
	protected void addScore(int score){
		_scores.get(GUI.getLevel()).add(score);
	}

	public String getAverageScore(int level){
		int total = 0;
		if ((_scores.get(level)).size() == 0){
			return "-";
		}
		for(int i : _scores.get(level)){
			total += i;
		}
		double avg = (double)total / (_scores.get(level).size());
		return avg + "";
	}
	public double getAverageDoubleScore(int level){
  		int total = 0;
  		if ((_scores.get(level)).size() == 0){
 			return 0.0;
  		}
  		for(int i : _scores.get(level)){
  			total += i;
  		}
 		double avg = (double)total / (_scores.get(level).size());
 		return avg*10;
  	}

	public WordList getWordList(String level){
		return _wordLists.get(level);
	}
	public ArrayList<String> getListNames(){
		ArrayList<String> names = new ArrayList<String>();
		for(String i : _wordLists.keySet()){
			names.add(i);
		}
		Collections.sort(names);
		return names;
	}
	public int getLongestStreak(){
		return _longestStreak;
	}
	public int getStreak(){
		return _currentStreak;
	}
	public int getWordsRight(){
		return _numberOfWordsRight;
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
	public int getNumberOfLevels(){

		return _wordLists.size();
	}
	public void setUpScores(){
		_scores = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<GUI.NUMBER_OF_LEVELS; i++){
			_scores.add(new ArrayList<Integer>());
		}
	}
	public void clearStats(){
		_mastered = new WordList();
		_faulted = new WordList();
		_failed = new WordList();
		_lastFailed = new WordList();
		setUpScores();
	}
	public void writeAllStats(){
		try {
			writeStreaksToFile();
			writeListToFiles(_mastered.returnArrayList(), MASTERED);
			writeListToFiles(_faulted.returnArrayList(), FAULTED);
			writeListToFiles(_failed.returnArrayList(), FAILED);
			writeListToFiles(_lastFailed.returnArrayList(), LAST_FAILED);
		} catch (FileNotFoundException | UnsupportedEncodingException e) {

			e.printStackTrace();
		}
	}
	private void writeListToFiles(ArrayList<String> list, String filename) throws FileNotFoundException, UnsupportedEncodingException{
		//From: http://stackoverflow.com/questions/2885173/how-to-create-a-file-and-write-to-a-file-in-java
		PrintWriter writer = new PrintWriter(filename);
		for(String i : list){
			writer.println(i);
		}
		writer.close();

	}
	
	private void writeStreaksToFile() throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(STREAK_VALUES);
		writer.println(_longestStreak + " " + _currentStreak + " " + _numberOfWordsRight);
		writer.close();
	}

}
