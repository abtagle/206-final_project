package voxSpell.achievements;

import voxSpell.quiz.Lists;
/**
 * Class representing achievements for the number of words right
 * @author atag549
 * Last Modified: 21 October, 2016
 *
 */
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
