package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringEscapeUtils;

import model.*;

/**
 * Data Access Object for Recipe table in database. Provides encapsulated
 * methods for controller to get, update, create and delete data in the Recipe
 * table.
 * 
 * @author Hanzhi.Zhuang & Bo Jiao
 *
 */
public class RecipeDAO extends BaseConnector {
//	Statement sql;
//	ResultSet result;

	/**
	 * get all recipe in the table.
	 * 
	 * @return a list of recipe objects
	 * @throws Exception
	 */
	public static List<Recipe> getAllRecipes() throws Exception {
		Connection conn = BaseConnector.startConnection();
		String sql = "select * from recipe";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		List<Recipe> recipeList = new ArrayList<Recipe>();
		while (result.next()) {
			Recipe recipe = new Recipe();
			recipe.setId(result.getInt("id"));
			recipe.setRecipeName(result.getString("recipeName"));
			recipe.setPreparationTime(result.getString("preparationTime"));
			recipe.setCookingTime(result.getString("cookingTime"));
			recipe.setPeopleAvailable(result.getInt("peopleAvailable"));
			recipe.setImagePath(result.getString("imagePath"));
			String newLine = StringEscapeUtils.unescapeJava(result.getString("instruction"));
			recipe.setInstruction(newLine);
			recipe.setIsFavourited(result.getInt("isFavourited"));
			recipeList.add(recipe);
		}
		BaseConnector.closeAll(conn, stmt, result);
		return recipeList;
	}
	
	/**
	 * use recipe name to search for the specific recipe in the table.
	 * 
	 * @param rName name of recipe
	 * @return a recipe object
	 * @throws Exception
	 */
	public static Recipe getRecipeByName(String rName) throws Exception {

		Connection conn = BaseConnector.startConnection();
		String sql = "select * from recipe " + "where recipeName = '" + rName + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		Recipe recipe = new Recipe();
		while (result.next()) {
			recipe.setId(result.getInt("id"));
			recipe.setRecipeName(result.getString("recipeName"));
			recipe.setPreparationTime(result.getString("preparationTime"));
			recipe.setCookingTime(result.getString("cookingTime"));
			recipe.setPeopleAvailable(result.getInt("peopleAvailable"));
			recipe.setImagePath(result.getString("imagePath"));
			recipe.setInstruction(result.getString("instruction"));
			recipe.setIsFavourited(result.getInt("isFavourited"));
		}
		BaseConnector.closeAll(conn, stmt, result);

		return recipe;
	}

	/**
	 * use fuzzy search on the given name to get the target recipes.
	 * 
	 * @param rName recipe name
	 * @return list of result recipes from database.
	 * @throws Exception
	 */
	public static List<Recipe> getRecipesByName(String rName) throws Exception {
		Connection conn = BaseConnector.startConnection();
		String sql = "select * from recipe " + "where recipeName like '%" + rName + "%'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet result = stmt.executeQuery();
		List<Recipe> recipeList = new ArrayList<Recipe>();
		while (result.next()) {
			Recipe recipe = new Recipe();
			recipe.setId(result.getInt("id"));
			recipe.setRecipeName(result.getString("recipeName"));
			recipe.setPreparationTime(result.getString("preparationTime"));
			recipe.setCookingTime(result.getString("cookingTime"));
			recipe.setPeopleAvailable(result.getInt("peopleAvailable"));
			recipe.setImagePath(result.getString("imagePath"));
			recipe.setInstruction(result.getString("instruction"));
			recipe.setIsFavourited(result.getInt("isFavourited"));
			recipeList.add(recipe);
		}
		BaseConnector.closeAll(conn, stmt, result);
		return recipeList;
	}

	/**
	 * create a new recipe record in the database with the given recipe object.
	 * 
	 * @param newRecipe
	 * @return the id of the new recipe record created by the database.
	 * @throws Exception
	 */
	public static int createNewRecipe(Recipe newRecipe) throws Exception {
		int state;
		int recipeId;
		Connection conn = BaseConnector.startConnection();
		String sql = "Insert into recipe (recipeName, preparationTime, cookingTime, instruction)"
				+ "values('"  + newRecipe.getRecipeName() + "','"+ newRecipe.getPreparationTime() + "','"
				+ newRecipe.getCookingTime() + "','"  + newRecipe.getInstruction() + "')";
		PreparedStatement stmt = conn.prepareStatement(sql);
		state = stmt.executeUpdate();
		recipeId = new RecipeDAO().getRecipeByName(newRecipe.getRecipeName()).getId();
		if (state == 1) {
			return recipeId;
		} else {
			return state;
		}
	}

	/**
	 * use the given id to update the recipe in the database with the given
	 * information in the object.
	 * 
	 * @param recipe with the id of the recipe in the database that you want to
	 *               update.
	 * @return if the update process is successful, return 1, otherwise 0.
	 * @throws Exception
	 */
	public static int updateRecipe(Recipe recipe) throws Exception {
		int state;
		Connection conn = BaseConnector.startConnection();
		String sql = "update recipe set recipeName='" + recipe.getRecipeName() + "',preparationTime='" 
				+ recipe.getPreparationTime() + "',cookingTime='"+ recipe.getCookingTime() 
				+ "', instruction = '" + recipe.getInstruction() + "', isFavourited = '" 
				+ recipe.getIsFavourited()+ "' where id = '" + recipe.getId() + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		state = stmt.executeUpdate();
		return state;
	}
	
	/**
	 * use the given id to set the recipe's isFavourited to 1(true)
	 * 
	 * @param recipe with the id of the recipe in the database that you want to
	 *               update.
	 * @return if the update process is successful, return 1, otherwise 0.
	 * @throws Exception
	 */
	public static int setRecipeFavourited(Recipe recipe) throws Exception {
		int state;
		Connection conn = BaseConnector.startConnection();
		String sql = "update recipe set isFavourited = '" 
				+ recipe.getIsFavourited()+ "' where id = '" + recipe.getId() + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		state = stmt.executeUpdate();
		return state;
	}

	/**
	 * delete the recipe in the database with the given recipe id.
	 * 
	 * @param recipe
	 * @return if the delete process is successful, return 1, otherwise 0.
	 * @throws Exception
	 */
	public static int deleteRecipe(Recipe recipe) throws Exception {
		int state;
		Connection conn = BaseConnector.startConnection();
		String sql = "delete from recipe where id= '" + recipe.getId() + "'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		state = stmt.executeUpdate();
		return state;
	}

// --------------------------for testing the above methods.---------------------------
	
//	public static void main(String args[]) {
//		Recipe r = null;
//		List<Recipe> rl = new ArrayList<Recipe>();
//		List<Ingredient> ingredients  = new LinkedList<Ingredient>();
//		Recipe nr = new Recipe();
//		nr.setId(14);
//		nr.setRecipeName("Roast Duckk");
//		nr.setDescription("a duck being roastedd");
//		nr.setPreparationTime(600);
//		nr.setCookingTime(600);
//		nr.setPeopleAvailable(20);
//		nr.setImagePath("picture.jpgg");
//		nr.setStep("1.one\n2.tw0\n3.threee");
//		nr.setStatus(11);
//		try {
//			r = new RecipeDAO().getRecipeByName("Hong Shao Rou");
//			rl = new RecipeDAO().getRecipesByName("ong");
//			ingredients = new IngredientDAO().getIngredientsByRecipeID(r.getId()+"");
//			System.out.println( new RecipeDAO().createNewRecipe(nr));
//			System.out.println( new RecipeDAO().updateRecipe(nr));
//			System.out.println( new RecipeDAO().deleteRecipe(nr));	
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(nr.toString());
//		System.out.println(ingredients.toString());
//		System.out.println(rl.toString());
//		System.out.println(r.toString());

//	}
}
