package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.util.Optional;

import dao.IngredientDAO;
import dao.RecipeDAO;

import model.Cookbook;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;

/**
 * the controller of the recipeview
 * 
 * @author Hao Yuan & Bo Jiao
 *
 */
public class RecipeViewController {

	@FXML
	private ImageView recipeimg;
	@FXML
	private Button backButton;
	@FXML
	private Label recipyName;
	@FXML
	private TextArea text;
	@FXML
	private AnchorPane pane;
	// Event Listener on Button[#backButton].onAction
	@FXML
	private RadioButton likeButton;
	@FXML
	private Button deleteButton;
	@FXML
	private ScrollBar numberBar;
	@FXML
	private Label numberText;
	@FXML
	private Button editButton;

	/**
	 * when click the back button
	 * 
	 * @param event event in this case
	 */
	public void bbEvent(ActionEvent event) {
		AnchorPane scene1 = null;
		BorderPane rootLayout = null;
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
			scene1 = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		backButton.getScene().setRoot(rootLayout);
		rootLayout.setCenter(scene1);
	}

	/**
	 * when click the like button
	 * 
	 * @param event event in this case
	 */
	public void lbEvent(ActionEvent event) {

		if (likeButton.isSelected()) {
			Cookbook.nowRecipe.setFavourited(1);
			try {
				RecipeDAO.updateRecipe(Cookbook.nowRecipe);
			} catch (Exception e) {

			}

			Alert alert = new Alert(AlertType.INFORMATION,
					"You've favourited it!\n" + "You can find it in the Favourites Page!");
			alert.showAndWait();

		} else {
			Cookbook.nowRecipe.setFavourited(0);

			Alert alert = new Alert(AlertType.INFORMATION, "You've removed it from your Favourites!");
			alert.showAndWait();

		}
	}

	/**
	 * when click the delete button
	 * 
	 * @param event event in this case
	 */
	public void dbEvent(ActionEvent event) {

		Alert alert = new Alert(AlertType.WARNING, "Are you sure to delete this? You CANNOT undo this action!",
				ButtonType.YES, ButtonType.CANCEL);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.YES) { // User authorizes the action.

			try {
				RecipeDAO.deleteRecipe(Cookbook.nowRecipe);
				IngredientDAO.deleteIngredientByRecipeID(Cookbook.nowRecipe.getId());
			} catch (Exception e) {

			}
			Cookbook.recipeList.remove(Cookbook.nowRecipe);

			AnchorPane scene1 = null;
			BorderPane rootLayout = null;
			try {
				rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
				scene1 = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			backButton.getScene().setRoot(rootLayout);
			rootLayout.setCenter(scene1);
		}

	}

	/**
	 * when click the edit button
	 * 
	 */
	public void ebEvent() {
		AnchorPane editView = null;
		BorderPane rootLayout = null;
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
			editView = FXMLLoader.load(getClass().getResource("/view/EditView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		editButton.getScene().setRoot(rootLayout);
		rootLayout.setCenter(editView);
	}

	/**
	 * the initialize of the recipe view scene
	 */
	public void initialize() {
		if (!(Cookbook.nowRecipe.getImagePath() == null))
			recipeimg.setImage(
					new Image(getClass().getResourceAsStream("/recipepics/" + Cookbook.nowRecipe.getImagePath())));
		else
			recipeimg.setImage(null);
		recipyName.setText(Cookbook.nowRecipe.toString());
		text.setText(Cookbook.nowRecipe.showRecipe());
		if (Cookbook.nowRecipe.isFavourited() == 1)
			likeButton.setSelected(true);
		numberBar.setMax(10);
		numberBar.setMin(1);
		numberBar.setValue(Cookbook.nowRecipe.getPeopleAvailable());
		numberText.setText("" + Cookbook.nowRecipe.getPeopleAvailable());
		numberBar.valueProperty()
				.addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
					numberText.setText(new_val.intValue() + "");
					text.setText(Cookbook.nowRecipe.showRecipeTimesX(new_val.intValue()));
				});
	}
}
