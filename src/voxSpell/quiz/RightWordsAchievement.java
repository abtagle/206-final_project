package voxSpell.quiz;

public class RightWordsAchievement extends Achievement {
	
	private int _numberOfWords;
	public RightWordsAchievement(String name, int numberOfWords){
		super(name);
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
