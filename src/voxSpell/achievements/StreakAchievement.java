package voxSpell.achievements;

import voxSpell.quiz.Lists;
/**
 * Class representing achievements for consecutive correct answers (streaks)
 * @author atag549
 *Last Modified: 21 October, 2016
 */
public class StreakAchievement extends Achievement {
	
	private int _streakValue;

	public StreakAchievement(String name, String videoName, int streakValue) {
		super(name, videoName);
		_streakValue = streakValue;
	}

	protected boolean isAchieved() {
		if(Lists.getInstance().getLongestStreak() >= _streakValue){
			return true;
		} else{
			return false;
		}
	}

}
