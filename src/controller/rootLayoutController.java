package controller;

import javafx.fxml.FXML;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;

/**
 * controller of the rootlayout view
 * 
 * @author Bo Jiao & Hao Yuan
 *
 */
public class rootLayoutController {
	@FXML
	private MenuItem closeItem;
	@FXML
	private MenuItem aboutItem;

	// Event Listener on MenuItem[#closeItem].onAction
	/**
	 * when click the close button
	 * 
	 * @param event the event in this case
	 */
	@FXML
	public void closeEvent(ActionEvent event) {
		System.exit(0);
	}

	// Event Listener on MenuItem[#aboutItem].onAction
	/**
	 * when click the about button
	 * 
	 * @param event the event in this case
	 */
	@FXML
	public void aboutEvent(ActionEvent event) {

		Alert alert = new Alert(AlertType.CONFIRMATION,
				"Feeling bored with the old recipes? Let's get sth new online! \n\n"
						+ "[We are getting you to: www.allrecipes.com]",
				ButtonType.YES, ButtonType.CANCEL);

		Optional<ButtonType> result = alert.showAndWait();

		if (result.get() == ButtonType.YES) { // User permits the action.
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(new URI("https://www.allrecipes.com/"));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
