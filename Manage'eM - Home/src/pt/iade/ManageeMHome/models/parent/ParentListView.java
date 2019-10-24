package pt.iade.ManageeMHome.models.parent;

import javafx.collections.ObservableList;

public class ParentListView {
	private String name;
	private ObservableList<Parent> age;
	public ParentListView(String name, ObservableList<Parent> age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public ObservableList<Parent> getAge() {
		return age;
	}
	@Override
	public String toString() {
		return  getName();
	}
}