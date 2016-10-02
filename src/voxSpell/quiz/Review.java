package voxSpell.quiz;

import java.util.ArrayList;

public class Review {
	private ArrayList<String> _reviewList;
	private int wordNumber;

	public Review(boolean isFailed){
		if(isFailed){
			_reviewList = Lists.getInstance().getLastFailed().returnArrayList();
		} else{
			_reviewList = Lists.getInstance().getWordList(Settings.getInstance().getLevel()).returnArrayList();
		}
		wordNumber = 0;
	}
	
	public int getWordNumber(){
		return wordNumber;
	}
	
	public String getWord(){
		return _reviewList.get(wordNumber);
	}
	
	public void nextWord(){
		if(wordNumber < _reviewList.size()-1){
			wordNumber++;
		}
	}
	public void previousWord(){
		if(wordNumber != 0){
			wordNumber--;
		}
	}
	public void sayWord(){
		new SayAnything(getWord()).execute();
	}
	public int getLength(){
		return _reviewList.size();
	}

}
