package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;

/**
 * Data Access Object for Ingredient table in database. Provides encapsulated
 * methods for controller to get, update, create and delete data in the
 * Ingredient table.
 * 
 * @author Hanzhi.Zhuang
 *
 */
public class IngredientDAO {
//	Statement sql;
//	ResultSet result;

	/**
	 * use recipe id to search for the target ingredient information in the table.
	 * 
	 * @param rid recipe id
	 * @return list of result Ingredients from database
	 * @throws Exception
	 */
	public static List<Ingredient> getIngredientsByRecipeId(int rid) throws Exception {
		Connection conn = BaseConnector.startConnection();
		String sql = "select * from ingredient where recipeId = '" + rid + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		List<Ingredient> ingredientList = new ArrayList<Ingredient>();
		while (result.next()) {
			Ingredient ingredient = new Ingredient();
			ingredient.setId(result.getInt("id"));
			ingredient.setIngredientName(result.getString("ingredientName"));
			ingredient.setRecipeID(result.getInt("recipeID"));
			ingredient.setQuantity(result.getInt("quantity"));
			ingredient.setUnit(result.getString("unit"));
			ingredient.setPretreatment(result.getString("pretreatment"));
			ingredientList.add(ingredient);
		}
		BaseConnector.closeAll(conn, stmt, result);
		return ingredientList;
	}

	/**
	 * use recipe id and ingredient name to search for the specific ingredient in
	 * the table.
	 * 
	 * @param rid            recipe id
	 * @param ingredientName
	 * @return an ingredient object
	 * @throws Exception
	 */
	private static Ingredient getIngredientByRecipeIdAndIngredientName(String rid, String ingredientName) throws Exception {
		Connection conn = BaseConnector.startConnection();
		String sql = "select * from ingredient where recipeID = '" + rid + "' and ingredientName = '" + ingredientName
				+ "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		Ingredient ingredient = new Ingredient();
		while (result.next()) {
			ingredient.setId(result.getInt("id"));
			ingredient.setIngredientName(result.getString("ingredientName"));
			ingredient.setRecipeID(result.getInt("recipeID"));
			ingredient.setQuantity(result.getInt("quantity"));
			ingredient.setUnit(result.getString("unit"));
			ingredient.setPretreatment(result.getString("pretreatment"));
		}
		BaseConnector.closeAll(conn, stmt, result);
		return ingredient;
	}

	/**
	 * create a new ingredient record in the database with the given ingredient
	 * object.
	 * 
	 * @param newIngredient
	 * @return the id of the new ingredient record created by the database
	 * @throws Exception
	 */
	public static int createNewIngredient(Ingredient newIngredient) throws Exception {
		int state;
		int ingredientId;
		Connection conn = BaseConnector.startConnection();
		String sql = "Insert into ingredient (ingredientName, recipeID, quantity, unit, pretreatment)"
				+ "values('" + newIngredient.getIngredientName() + "','"
				+ Cookbook.nowRecipe.getId() + "','" + newIngredient.getQuantity() + "','" + newIngredient.getUnit()
				+ "','" + newIngredient.getPretreatment() + "')";
		PreparedStatement stmt = conn.prepareStatement(sql);
		state = stmt.executeUpdate();
		new IngredientDAO();
		ingredientId = IngredientDAO.getIngredientByRecipeIdAndIngredientName(newIngredient.getRecipeID() + "",
				newIngredient.getIngredientName()).getId();
		if (state == 1) {
			return ingredientId;
		} else {
			return state;
		}
	}

	/**
	 * use the given id to update the ingredient in the database with the given
	 * ingredient information in the object.
	 * 
	 * @param ingredient with the id of the ingredient in the database that you want
	 *                   to update.
	 * @return if the update process is successful, return 1, otherwise 0.
	 * @throws Exception
	 */
	public static int updateIngredient(Ingredient ingredient) throws Exception {
		int state;
		Connection conn = BaseConnector.startConnection();
		String sql = "update ingredient set ingredientName='" + ingredient.getIngredientName() + "',quantity='"
				+ ingredient.getQuantity() + "',unit='" + ingredient.getUnit() + "',pretreatment='"
				+ ingredient.getPretreatment() + "' where id = '" + ingredient.getId() + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		state = stmt.executeUpdate();
		return state;
	}

	/**
	 * delete the ingredient in the database with the given recipe id.
	 * 
	 * @param integer recipe id
	 * @return if the delete process is successful, return 1, otherwise 0.
	 * @throws Exception
	 */
	public static int deleteIngredientByRecipeID(Integer integer) throws Exception {
		int state;
		Connection conn = BaseConnector.startConnection();
		String sql = "delete from Ingredient where recipeID='" + integer + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		state = stmt.executeUpdate();
		return state;
	}

	/**
	 * for testing the above methods.
	 * 
	 * @param args
	 */
//	public static void main(String args[]) {
//		Ingredient i = new Ingredient();
//		List<Ingredient> ri = new ArrayList<Ingredient>();
//		i.setIngredientName("very hot wate3");
//		i.setId(36);
//		i.setRecipeId(5);
//		i.setQuantity(133);
//		i.setUnit("kgg3");
//		i.setComments("boil it3");
//		i.setStatus(1);
//		try {
//			ri = new IngredientDAO().getIngredientsByRecipeId("1");
//			i = new IngredientDAO().getIngredientByRecipeIdAndIngredientName(2+"", "pork belly");
//			System.out.println(new IngredientDAO().createNewIngredient(i));
//			System.out.println(new IngredientDAO().updateIngredient(i));
//			System.out.println(new IngredientDAO().deleteIngredientByRecipeId(5+""));	
//		} catch (Exception e) {
		// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(ri.toString());
//		System.out.println(i.toString());

//	}

}
