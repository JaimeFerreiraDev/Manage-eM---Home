package pt.iade.ManageeMHome.models.kid;

import javafx.collections.ObservableList;

public class KidListView {
	private String name;
	private ObservableList<Kid> age;
	public KidListView(String name, ObservableList<Kid> age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public ObservableList<Kid> getAge() {
		return age;
	}
	@Override
	public String toString() {
		return  getName();
	}
}
