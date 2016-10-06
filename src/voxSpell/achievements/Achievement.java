package voxSpell.achievements;

public abstract class Achievement {
	
	protected String _name;
	protected String _videoName;
	
	public Achievement(String name, String _videoName){
		_name = name;
	}
	
	protected abstract boolean isAchieved();
	
	public String toString(){
		return _name;
	}

}
