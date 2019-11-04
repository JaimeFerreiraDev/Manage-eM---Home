package pt.iade.ManageeMHome.models.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import pt.iade.ManageeMHome.models.kid.Kid;
import pt.iade.ManageeMHome.models.parent.Parent;

public class LoginDAO {
private static ObservableList<Kid> kidLoginList = FXCollections.observableArrayList();
private static ObservableList<Parent> parentLoginList = FXCollections.observableArrayList();

public static ObservableList<Kid> kidLoginList() {
	return kidLoginList;
}
public static ObservableList<Parent> parentLoginList() {
	return parentLoginList;
}
static{
	
}
}
/*
 * CRIAR KIDS E PARENTS PARA O LOGIN
 * CRIAR PERSONS
 * CRIAR NOVOS TIPOS APENAS COM USERNAME, PASSWORD E TYPE (Parent/kid)
 * 
 */
