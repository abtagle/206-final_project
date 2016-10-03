package voxSpell.quiz;

public abstract class Achievement {
	
	protected String _name;
	
	public Achievement(String name){
		_name = name;
	}
	
	protected abstract boolean isAchieved();
	
	public String toString(){
		return _name;
	}

}
