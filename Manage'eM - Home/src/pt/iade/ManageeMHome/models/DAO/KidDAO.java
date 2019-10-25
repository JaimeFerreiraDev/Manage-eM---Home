package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.kid.Kid;

public class KidDAO {
private static ObservableList<Kid> kidList = FXCollections.observableArrayList();

public static ObservableList<Kid> getKidList() {
	return kidList;
}

static{
	
}
}
