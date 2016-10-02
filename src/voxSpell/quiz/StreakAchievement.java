package voxSpell.quiz;

public class StreakAchievement extends Achievement {
	
	private int _streakValue;

	public StreakAchievement(String name, int streakValue) {
		super(name);
		_streakValue = streakValue;
	}

	protected boolean isAchieved() {
		return false;
	}

}
