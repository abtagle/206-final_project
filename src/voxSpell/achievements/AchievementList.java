package voxSpell.achievements;

import java.util.ArrayList;
/**
 * Singleton class storing all the achievements.
 * @author atag549
 * Last Modified: 21 October, 2016
 *
 */
public class AchievementList {
	private ArrayList<Achievement> _achievements;
	private static AchievementList _this;
	/**
	 * Get instance of this singleton
	 * @return
	 */
	public static AchievementList getInstance(){
		if(_this == null){
			_this = new AchievementList();
		}
		return _this;
	}
	
	/**
	 * Private constructor
	 */
	private AchievementList(){
		_achievements = new ArrayList<Achievement>();
		_achievements.add(new StreakAchievement("10 Word Streak", "/streak10.avi", 10));
		_achievements.add(new StreakAchievement("25 Word Streak", "/streak25.avi",25));
		_achievements.add(new StreakAchievement("50 Word Streak", "/streak50.avi",50));
		_achievements.add(new RightWordsAchievement("50 Words Right", "/right50.avi", 50));
		_achievements.add(new RightWordsAchievement("100 Words Right", "/right100.avi", 100));
		_achievements.add(new RightWordsAchievement("250 Words Right", "/right250.avi", 250));
	}
	/**
	 * Checks if there have been any changes in the status of achievements, and returns the achievements that have changed
	 * @param original
	 * @return
	 */
	public ArrayList<Achievement> checkChange(ArrayList<Boolean> original){
		ArrayList<Achievement> changed = new ArrayList<Achievement>();
		for(int i = 0; i < _achievements.size(); i++){
			if(_achievements.get(i).isAchieved() != original.get(i)){
				changed.add(_achievements.get(i));
			}
		}
		return changed;
		
	}
	
	/**
	 * Returns a shallow copy of the achievement list that exists at any given time
	 * @return
	 */
	public ArrayList<Boolean> getShallowCopy(){
		ArrayList<Boolean> achievements = new ArrayList<Boolean>();
		for(Achievement i : _achievements){
			achievements.add(i.isAchieved());
		}
		return achievements;
	}
	
	/**
	 * Returns the achievement at that index in the encapsulated array
	 * @param achievement
	 * @return
	 */
	public Achievement getAchievement(int achievement){
		return _achievements.get(achievement);
	}
}
