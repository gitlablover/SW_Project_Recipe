package model;

import java.util.ArrayList;
import java.util.List;

import dao.*;

/**
 * the main model class
 * 
 * @author Bo Jiao & Hao Yuan on 2021/06/25
 *
 */
public class Cookbook {
	public static Recipe nowRecipe;
	
	
//  -----------------------------------FOR TESTING ONLY----------------------------------------
	
//	public static Ingredient prok = new Ingredient("Prok", "g", 500, "cut into cubes");
//	public static Ingredient pepper = new Ingredient("Pepper", " ", 2, "cut into slices");
//	public static Ingredient beaf = new Ingredient("Beaf", "g", 300, "cut into slices");
	
//	public static Recipe Qingjiaoniuliu = new Recipe("Qing Jiao Niu Liu", "10min", "60min", 7,
//			"1.clean and cut beaf\n 2.put it into the oil.", "hawaiian-pizza.jpg", beaf, pepper);
//	public static Recipe hongshaorou = new Recipe("Hong Shao Rou", "5min", "45min", 4,
//			"1.clean and cut the prok.\n 2.put it into the oil.", "hawaiian-pizza.jpg", prok);
	
//  -----------------------------------FOR TESTING ONLY----------------------------------------
	
	public static List<Ingredient> userIn = new ArrayList<Ingredient>();
	public static List<Recipe> recipeList = new ArrayList<Recipe>();

	
	/**
	 * Controller of main model class, initialize the local data according to the Database
	 */
	public Cookbook() {
		
//  ---------------FOR TESTING ONLY-----------------
//		recipeList.add(hongshaorou);
//		recipeList.add(Qingjiaoniuliu);
//  ---------------FOR TESTING ONLY-----------------
		
		try{
			recipeList = RecipeDAO.getAllRecipes();
		}catch(Exception e) {
//			System.out.println(e);
		}
		for(Recipe i:recipeList) {
//			System.out.println(i.getRecipeName());
			try{
				i.setIngredientList(IngredientDAO.getIngredientsByRecipeId(i.getId()));
			}catch(Exception e) {
//				System.out.println(e);
			}
		}
		
	}

	/**
	 * Updates the local data according to the Database when invoked
	 */
	public static void update() {
		try{
			recipeList = RecipeDAO.getAllRecipes();
		}catch(Exception e) {
//			System.out.println(e);
		}
		for(Recipe i:recipeList) {
//			System.out.println(i.getRecipeName());
			try{
				i.setIngredientList(IngredientDAO.getIngredientsByRecipeId(i.getId()));
			}catch(Exception e) {
//				System.out.println(e);
			}
		}
	}
}
