package voxSpell.quiz;

import java.util.ArrayList;

public class AchievementList {
	private ArrayList<Achievement> _achievements;
	private static AchievementList _this;
	
	public static AchievementList getInstance(){
		if(_this == null){
			_this = new AchievementList();
		}
		return _this;
	}
	
	private AchievementList(){
		_achievements = new ArrayList<Achievement>();
		_achievements.add(new StreakAchievement("10 Word Streak", 10));
		_achievements.add(new StreakAchievement("25 Word Streak", 25));
		_achievements.add(new StreakAchievement("50 Word Streak", 50));
		_achievements.add(new StreakAchievement("50 Words Right", 10));
		_achievements.add(new StreakAchievement("100 Words Right", 25));
		_achievements.add(new StreakAchievement("250 Words Right", 50));
	}
	
	protected ArrayList<Achievement> checkChange(ArrayList<Achievement> original){
		ArrayList<Achievement> changed = new ArrayList<Achievement>();
		for(int i = 0; i < _achievements.size(); i++){
			if(_achievements.get(i).isAchieved() != original.get(i).isAchieved()){
				changed.add(_achievements.get(i));
			}
		}
		return changed;
		
	}
	
	protected ArrayList<Achievement> getShallowCopy(){
		return (ArrayList<Achievement>)_achievements.clone();
	}
}
