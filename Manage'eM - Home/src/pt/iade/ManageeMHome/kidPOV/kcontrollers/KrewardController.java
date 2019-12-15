package pt.iade.ManageeMHome.kidPOV.kcontrollers;

import javafx.fxml.FXML;
import pt.iade.ManageeMHome.Main;
/**
 * This class is not functional yet.
 * This class is a controller to the "kid reward window".
 * <p>The "Kid 1st time login window" is in this fxml file: {@link pt.iade.ManageeMHome.kidPOV.kviews#krewardView.fxml}.
 * @author jaime
 *
 */
public class KrewardController {
	@FXML
	private void taskClick() {
		Main.changeTab("kidPOV/kviews/ktaskView.fxml", new KtaskController());
	}
}
