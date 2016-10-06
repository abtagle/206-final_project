package voxSpell.achievements;

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
		_achievements.add(new StreakAchievement("10 Word Streak", "streak10.mp4", 10));
		_achievements.add(new StreakAchievement("25 Word Streak", "streak25.mp4",25));
		_achievements.add(new StreakAchievement("50 Word Streak", "streak50.mp4",50));
		_achievements.add(new RightWordsAchievement("50 Words Right", "right50.mp4", 50));
		_achievements.add(new RightWordsAchievement("100 Words Right", "right100.mp4", 100));
		_achievements.add(new RightWordsAchievement("250 Words Right", "right250.mp4", 250));
	}
	
	public ArrayList<Achievement> checkChange(ArrayList<Boolean> original){
		ArrayList<Achievement> changed = new ArrayList<Achievement>();
		for(int i = 0; i < _achievements.size(); i++){
			if(_achievements.get(i).isAchieved() != original.get(i)){
				changed.add(_achievements.get(i));
			}
		}
		return changed;
		
	}
	
	public ArrayList<Boolean> getShallowCopy(){
		ArrayList<Boolean> achievements = new ArrayList<Boolean>();
		for(Achievement i : _achievements){
			achievements.add(i.isAchieved());
		}
		return achievements;
	}
}
