package pt.iade.ManageeMHome.models.notification;

import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.parent.Parent;

public class NotificationListView {

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
