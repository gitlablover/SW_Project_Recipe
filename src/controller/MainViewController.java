package controller;

import java.io.IOException;
import java.util.Optional;

import dao.RecipeDAO;
import model.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;

/**
 * the controller of the mainview
 * 
 * @author Hao Yuan & Bo Jiao
 *
 */
public class MainViewController {
	@FXML
	private Button SearchButton;
	@FXML
	private ListView list_1;
	@FXML
	private TextField text_1;
	@FXML
	private Button collectionButton;
	@FXML
	private Button addButton;
	@FXML
	private ImageView image;

	// Event Listener on Button[#SearchButton].onAction
	@SuppressWarnings("unchecked")
	@FXML
	/**
	 * when press the search button
	 * 
	 */
	public void sbEvent() {

		String sname = text_1.getText();
		ObservableList<Recipe> listData = FXCollections.observableArrayList();

		try {

			for (Recipe i : RecipeDAO.getRecipesByName(sname)) {
				listData.add(i);
			}
			;
		} catch (Exception e) {

		}
//		for (int i = 0; i < AppModel.recipeList.size(); i++) {
//			if (AppModel.recipeList.get(i).toString().equals(sname))
//				listData.add(AppModel.recipeList.get(i));
//		}

		list_1.setItems(listData);
//		list_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			@Override
//			public void handle(MouseEvent event) {
//				if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) // main.changeStage();
//				{
//					AppModel.nowRecipe = listData.get(0);
//					AnchorPane scene2 = null;
//					BorderPane rootLayout = null;
//					try {
//						rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
//						scene2 = FXMLLoader.load(getClass().getResource("/view/RecipeView.fxml"));
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					SearchButton.getScene().setRoot(rootLayout);
//					rootLayout.setCenter(scene2);
//				}
//			}
//		});

		if (listData.isEmpty()) {
			Alert alert = new Alert(AlertType.INFORMATION, "Found nothing!");
			alert.showAndWait();
		} else
			list_1.setEffect(null);
	}

	/**
	 * when press the collection button
	 * 
	 */
	public void cbEvent() {

		Alert alert = new Alert(AlertType.INFORMATION, "View the collection?", ButtonType.YES, ButtonType.CANCEL);
		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == ButtonType.YES) { // User authorizes the action.
			ObservableList<Recipe> listData = FXCollections.observableArrayList();
			for (int i = 0; i < Cookbook.recipeList.size(); i++) {
				if (Cookbook.recipeList.get(i).isFavourited() == 1)
					listData.add(Cookbook.recipeList.get(i));
			}
			list_1.setItems(listData);
			list_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {

					if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) // main.changeStage();
					{
						if (!list_1.getSelectionModel().getSelectedItem().equals(null)) {
							Cookbook.nowRecipe = (Recipe) list_1.getSelectionModel().getSelectedItem();
							if (!(Cookbook.nowRecipe.getImagePath() == null))
								image.setImage(new Image(getClass()
										.getResourceAsStream("/recipepics/" + Cookbook.nowRecipe.getImagePath())));
							else
								image.setImage(null);
						}
					}

					if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) // main.changeStage();
					{
						if (list_1.getSelectionModel().getSelectedItem() == null) {
						} else {
							// Recipe nowr = (Recipe)list_1.getSelectionModel().getSelectedItem();
							Cookbook.nowRecipe = (Recipe) list_1.getSelectionModel().getSelectedItem();
							AnchorPane scene2 = null;
							BorderPane rootLayout = null;
							try {
								rootLayout = FXMLLoader.load(getClass().getResource("/view/rootLayout.fxml"));
								scene2 = FXMLLoader.load(getClass().getResource("/view/RecipeView.fxml"));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							SearchButton.getScene().setRoot(rootLayout);
							rootLayout.setCenter(scene2);
						}
//						AppModel.nowRecipe = (Recipe) list_1.getSelectionModel().getSelectedItem();
//						AnchorPane scene2 = null;
//						BorderPane rootLayout = null;
//						try {
//							rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
//							scene2 = FXMLLoader.load(getClass().getResource("/view/RecipeView.fxml"));
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						SearchButton.getScene().setRoot(rootLayout);
//						rootLayout.setCenter(scene2);
					}
				}
			});
			if (listData.isEmpty()) {
				Alert alert1 = new Alert(AlertType.INFORMATION, "The collection is empty!");
				alert1.showAndWait();

			}
		}
	}

	/**
	 * when press the add button
	 * 
	 */
	public void abEvent() {
		AnchorPane scene2 = null;
		BorderPane rootLayout = null;
		try {
			rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
			scene2 = FXMLLoader.load(getClass().getResource("/view/AddView.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SearchButton.getScene().setRoot(rootLayout);
		rootLayout.setCenter(scene2);
	}

	/**
	 * the initialize of the mainview
	 */
	public void initialize() {
		list_1.setEffect(null);
		ObservableList<Recipe> listData = FXCollections.observableArrayList();
		for (int i = 0; i < Cookbook.recipeList.size(); i++) {
			listData.add(Cookbook.recipeList.get(i));
		}

		list_1.setItems(listData);
		list_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) // main.changeStage();
				{
					if (list_1.getSelectionModel().getSelectedItem() == null) {}
					else{
						Cookbook.nowRecipe = (Recipe) list_1.getSelectionModel().getSelectedItem();
						if (!(Cookbook.nowRecipe.getImagePath() == null))
							image.setImage(new Image(getClass()
									.getResourceAsStream("/recipepics/" + Cookbook.nowRecipe.getImagePath())));
						else
							image.setImage(null);
					}
				}

				if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 2) // main.changeStage();
				{
					if (list_1.getSelectionModel().getSelectedItem() == null) {}
					else {
						Cookbook.nowRecipe = (Recipe) list_1.getSelectionModel().getSelectedItem();
						AnchorPane scene2 = null;
						BorderPane rootLayout = null;
						try {
							rootLayout = FXMLLoader.load(getClass().getResource("/view/rootLayout.fxml"));
							scene2 = FXMLLoader.load(getClass().getResource("/view/RecipeView.fxml"));
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						SearchButton.getScene().setRoot(rootLayout);
						rootLayout.setCenter(scene2);
					}
//					AppModel.nowRecipe = listData.get(0);
//					AnchorPane scene2 = null;
//					BorderPane rootLayout = null;
//					try {
//						rootLayout = FXMLLoader.load(getClass().getResource("/view/RootLayout.fxml"));
//						scene2 = FXMLLoader.load(getClass().getResource("/view/RecipeView.fxml"));
//					} catch (IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					SearchButton.getScene().setRoot(rootLayout);
//					rootLayout.setCenter(scene2);
				}
			}
		});
	}
}
