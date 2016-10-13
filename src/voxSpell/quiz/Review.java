package voxSpell.quiz;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Class representing the review functionality (flashcards someone can navigate to learn things) in this application
 * @author atag549
 * Last Modified 14 October, 2016
 *
 */
public class Review {
	private ArrayList<String> _reviewList;
	private int wordNumber;

	public Review(boolean isFailed){
		if(isFailed){
			_reviewList = Lists.getInstance().getLastFailed().returnArrayList();
		} else{
			_reviewList = Lists.getInstance().getWordList(Settings.getInstance().getLevel()).returnArrayList();
		}
		Collections.sort(_reviewList);
		wordNumber = 0;
	}
	
	public int getWordNumber(){
		return wordNumber;
	}
	
	public String getWord(){
		return _reviewList.get(wordNumber);
	}
	
	public void nextWord(){
		if(wordNumber < getLength()-1){
			wordNumber++;
		} else{
			wordNumber = 0;
		}
	}
	public void previousWord(){
		if(wordNumber != 0){
			wordNumber--;
		} else{
			wordNumber = getLength()-1;
		}
	}
	public void sayWord(){
		new SayAnything(getWord()).execute();
	}
	public int getLength(){
		return _reviewList.size();
	}
	public void removeWord(){
		_reviewList.remove(wordNumber);
		if(wordNumber == _reviewList.size()){
			wordNumber -=1;
		} 
	}
	public ArrayList<String> getReviewList(){
		return _reviewList;
	}

}
