package voxSpell.quiz;

public class StreakAchievement extends Achievement {
	
	private int _streakValue;

	public StreakAchievement(String name, int streakValue) {
		super(name);
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
