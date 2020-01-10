package pt.iade.ManageeMHome.models;
/**
 * This class is what we use to represent Rewards.
 * @author jaime
 *
 */
public class Reward {
	private String name;
	private int points;
	private int id;
	private Kid kid;
	public Reward( String name,int points, int id) {
		this.name = name;
		this.points=points;
		this.id=id;
	}
	
	public Reward( String name,int points,int id, Kid kid) {
		this(name, points,id);
		this.kid= kid;
	}
	
	
	
	
	public String getName() {
		return name;
	}
	public int getPoints() {
		return points;
	}
	public int getId() {
		return id;
	}

	public Kid getKid() {
		return kid;
	}
	
	
}
