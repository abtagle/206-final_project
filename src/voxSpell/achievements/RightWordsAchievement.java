package voxSpell.achievements;

import voxSpell.quiz.Lists;

public class RightWordsAchievement extends Achievement {
	
	private int _numberOfWords;
	public RightWordsAchievement(String name, String videoName, int numberOfWords){
		super(name, videoName);
		_numberOfWords = numberOfWords;
	}
	
	@Override
	protected boolean isAchieved() {
		if(Lists.getInstance().getWordsRight() >= _numberOfWords){
			return true;
		} else{
			return false;
		}
	}

}
