package voxSpell.quiz;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class representing a word list, storing words with a backing ArrayList<String>
 * Convenient due to the operations required to occur on lists of words.
 * 
 * Taken from Softeng 206 Assignment 2 submission by Aimee Tagle
 * Last Modified: During 19 September, 2016
 * 
**/
public class WordList {
	private ArrayList<String> _words;
	
	public WordList(){
		_words = new ArrayList<String>();
	}
	
	public void addWord(String word){
		_words.add(word);
	}
	
	/**
	 * Returns the list the user will be tested on in the quiz
	 * @return
	 */
	public ArrayList<String> returnTestlist(){
		@SuppressWarnings("unchecked")
		ArrayList<String> shufWords = (ArrayList<String>) _words.clone();
		Collections.shuffle(shufWords);
		ArrayList<String> returnList = new ArrayList<String>();
		int i = 0;
		while(i < Settings.getInstance().getQuizSize() && i < shufWords.size()){
			returnList.add(shufWords.get(i));
			i++;
		}
		return returnList;
	}
	/**
	 * Returns true if the wordlist includes the parameter word
	 * @param word
	 * @return
	 */
	public boolean contains(String word){
		return _words.contains(word);
	}
	/**
	 * Removes the parameter word from the wordlist
	 * @param word
	 */
	public void remove(String word){
		_words.remove(word);
	}
	/**
	 * Returns the WordList as an ArrayList (the backing implementation)
	 * @return
	 */
	public ArrayList<String> returnArrayList(){
		return _words;
	}
	/**
	 * Returns the length of the wordlist
	 * @return
	 */
	public int length(){
		return _words.size();
	}
	/**
	 * Returns the frequency the parameter word occurs in the wordlist (not used in final project)
	 * @param word
	 * @return
	 */
	public int frequencyOf(String word){
		return Collections.frequency(_words, word);
	}
	/**
	 * Returns the word at the particular index of the list
	 * @param i
	 * @return
	 */
	public String getWord(int i){
		return _words.get(i);
	}
}
