package voxSpell.achievements;

/**
 * Abstract class representing an achievement, with all the things an achievement should have
 * @author atag549
 * Last Modified: 21 October, 2016
 *
 */
public abstract class Achievement {
	
	protected String _name;
	protected String _videoName;
	
	public Achievement(String name, String videoName){
		_name = name;
		_videoName = videoName;
	}
	
	/**
	 * Checks and returns if the achievement has been achieved
	 * @return
	 */
	protected abstract boolean isAchieved();
	
	/**
	 * Returns the name of the achievement as a string
	 */
	public String toString(){
		return _name;
	}
	/**
	 * Returns the name of the video reward associated with the achievement
	 * @return
	 */
	public String getVideoReward(){
		return _videoName;
	}

}
