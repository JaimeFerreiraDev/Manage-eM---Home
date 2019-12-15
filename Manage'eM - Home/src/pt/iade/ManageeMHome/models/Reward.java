package pt.iade.ManageeMHome.models;
/**
 * This class is what we use to represent Rewards.
 * @author jaime
 *
 */
public class Reward {
	private String name;
	private int points;
	public Reward( String name,int points) {
		this.name = name;
		this.points=points;
	}
	public String getName() {
		return name;
	}
	public int getPoints() {
		return points;
	}
}
