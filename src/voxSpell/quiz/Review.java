package voxSpell.quiz;

import java.util.ArrayList;

public class Review {
	private ArrayList<String> _reviewList;
	private int wordNumber;

	public Review(boolean isFailed){
		if(isFailed){
			_reviewList = Lists.getInstance().getFailed().returnArrayList();
		} else{
			_reviewList = Lists.getInstance().getWordList(Settings.getInstance().getLevel()).returnArrayList();
		}
		wordNumber = 0;
	}
	
	public void getWord(){
		_reviewList.get(0);
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

}
