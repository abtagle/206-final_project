package voxSpell.achievements;

public abstract class Achievement {
	
	protected String _name;
	protected String _videoName;
	
	public Achievement(String name, String videoName){
		_name = name;
		_videoName = videoName;
	}
	
	protected abstract boolean isAchieved();
	
	public String toString(){
		return _name;
	}
	public String getVideoReward(){
		return _videoName;
	}

}
