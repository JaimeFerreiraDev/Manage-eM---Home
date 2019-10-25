package pt.iade.ManageeMHome.models.task;

public class Task {
	private String name;
	private int points;
	private String details;
	public Task( String name,int points, String details/*, String username, String password*/) {
		this.name = name;
		this.points=points;
		this.details=details;
	}
	public String getName() {
		return name;
	}
	public int getPoints() {
		return points;
	}
	public String getDetails() {
		return details;
	}
}
