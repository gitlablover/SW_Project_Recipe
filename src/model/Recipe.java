package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The entity class Recipe is mapped with Recipe table in DB.
 * 
 * @author Bo Jiao on 2021/06/12
 */
public final class Recipe {

	/**
	 * ID of the recipe.
	 */
	private Integer id;

	/**
	 * Name of the recipe.
	 */
	private String recipeName;
	
	/**
	 * Preparation time of the recipe.
	 */
	private String preparationTime;
	
	/**
	 * Cooking time of the recipe.
	 */
	private String cookingTime;
	
	/**
	 * Number of people available to be served per dish.
	 */
	private int peopleAvailable=1;
	
	/**
	 * Image path of a recipe.
	 */
	private String imagePath;

	/**
	 * Instruction of the recipe as a String
	 */
	private String instruction;
	
	/**
	 * Ingredients of the recipe.
	 */
	private ArrayList<Ingredient> ingredientList = new ArrayList<Ingredient>();

	/**
	 * For identifying user collections
	 */
	private int isFavourited = 0;

	
	/** ==============Constructors============== */
	

	/**
	 * Custom constructor for testing
	 * @param name
	 * @param instruct
	 */
	public Recipe(String name, String instruct) {
		this.instruction = instruct;
		this.recipeName = name;
	}

	/**
	 * Custom constructor
	 * @param name
	 * @param preTime
	 * @param cookTime
	 * @param instruct
	 */
	public Recipe(String name, String preTime, String cookTime, String instruct) {
		this.instruction = instruct;
		this.recipeName = name;
		this.preparationTime = preTime;
		this.cookingTime = cookTime;
	}

	/**
	 * Default constructor of class Recipe.
	 */
	public Recipe() {
		// TODO Auto-generated constructor stub
	}

	/** ==============Operational Functions============== */
	/**
	 * the toString function
	 * 
	 * @return the name of this recipe
	 */
	public String toString() {
		return (this.recipeName);
	}

	/**
	 * the show recipe function
	 * 
	 * @return all the content of the recipe
	 */
	public String showRecipe() {
		String result = "";
		for (Ingredient i : ingredientList)
			result = result + "  ---- " + i.toString() + ";\n";
		return ("\nName:                 " +this.recipeName + "\n\n" + "Prepare time:                         " + preparationTime + "\n\n"+"Cook time:                           " + cookingTime
				+ "\n\n"+"Ingredients: \n" + result + "\n\n" + "Instructions: \n" + instruction);
	}

	/**
	 * show the recipe with the time x
	 * 
	 * @param x the times
	 * @return the string of the total content
	 */
	public String showRecipeTimesX(int x) {
		String result = "";
		for (Ingredient i : ingredientList) {
//			if(i.getQuantity()>10)
				result = result + "  ---- " + i.timesX(x, peopleAvailable) + ";\n";
//			else
//				result = result + "  ---- " + i.timesX(x) + ";\n";
		}
			
		return ("\nName:                 " +this.recipeName + "\n\n" + "Prepare time:                         " + preparationTime + "\n\n"+"Cook time:                           " + cookingTime
				+ "\n\n"+"Ingredients: \n" + result + "\n\n" + "Instructions: \n" + instruction);
	}

	/**
	 * add ingredients to the recipe
	 * 
	 * @param ingredients ingredients which will be added
	 */
	public void addIngredient(Ingredient... ingredients) {
		for (Ingredient i : ingredients) {
			ingredientList.add(i);
		}
	}


	/**
	 * the list of the ingredients in this recipe
	 * 
	 * @return the list of the ingredients in this recipe
	 */
	public ArrayList<Ingredient> getIngredientList() {
		return this.ingredientList;
	}


	/**
	 * clear all ingredients
	 * 
	 */
	public void clearIngredient() {
		this.ingredientList.clear();
	}

	/** ==============Getters and setters.============== */
	
	/**
	 * get whether the recipe is collected
	 * 
	 * @return true if the collected, false if not
	 */
	public int isFavourited() {
		return this.isFavourited;
	}

	/**
	 * set the recipe collected or not
	 * 
	 * @param bool true means collected, false means not
	 */
	public void setFavourited(int bool) {
		this.isFavourited = bool;
	}
	
	/**
	 * get the prepare time
	 * 
	 * @return the prepare time
	 */
	public String getPreparationTime() {
		return this.preparationTime;
	}

	/**
	 * setter of the prepare time
	 * 
	 * @param pretime the prepare time
	 */
	public void setPreparationTime(String pretime) {
		this.preparationTime = pretime;
	}

	/**
	 * getter of the cook time
	 * 
	 * @return the cook time
	 */
	public String getCookingTime() {
		return this.cookingTime;
	}

	/**
	 * setter of the cook time
	 * 
	 * @param cooktime the cook time
	 */
	public void setCookingTime(String cooktime) {
		this.cookingTime = cooktime;
	}
	
	public void setName(String name) {
		this.recipeName = name;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public int getIsFavourited() {
		return isFavourited;
	}

	public void setIsFavourited(int isFavourited) {
		this.isFavourited = isFavourited;
	}

	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = (ArrayList<Ingredient>) ingredientList;
	}

	public void setInstruction(String ins) {
		this.instruction = ins;
	}

	public String getInstruction() {
		return instruction;
	}

	public int getPeopleAvailable() {
		return peopleAvailable;
	}

	public void setPeopleAvailable(int peopleAvailable) {
		this.peopleAvailable = peopleAvailable;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
