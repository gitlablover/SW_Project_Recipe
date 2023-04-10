package model;

/**
 * The entity class ingredient is mapped with Ingredient table in DB.
 * 
 * @author Bo Jiao on 2021/06/12
 *
 */
public class Ingredient {
	
	/**
	 * id of the ingredient.
	 */
	private int id;
	
	/**
	 * name of the ingredient.
	 */
	private String ingredientName;
	
	/**
	 * unit of quantity.
	 */
	private String unit;
	
	/**
	 * quantity of ingredient.
	 */
	private int quantity;
	
	/**
	 * pretreatment of recipe
	 */
	private String pretreatment;
	
	/**
	 * id of the recipe that the ingredient belongs to.
	 */
	private int recipeID;

	
	/** ==============Constructors============== */
	
	/**
	 * Custom constructor of class Ingredient
	 * @param name
	 * @param unit
	 * @param number
	 * @param pre
	 */
	public Ingredient(String name, String unit, int number, String pre) {
		this.ingredientName = name;
		this.unit = unit;
		this.quantity = number;
		this.pretreatment = pre;
	}

	/**
	 * Default constructor of class Ingredient
	 */
	public Ingredient() {
		// TODO Auto-generated constructor stub
	}

	
	/** ==============Getters and setters.============== */

	public String getIngredientName() {
		return this.ingredientName;
	}

	public String getUnit() {
		return this.unit;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public String getPretreatment() {
		return pretreatment;
	}

	public void setPretreatment(String pretreatment) {
		this.pretreatment = pretreatment;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getpretreatment() {
		return this.pretreatment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRecipeID() {
		return recipeID;
	}

	public void setRecipeID(int recipeID) {
		this.recipeID = recipeID;
	}
	
	
	
	/** ==============toString functions.============== */
	
	/**
	 * the toString function
	 */
	public String toString() {
		String result;
		result = "  "+quantity + "  " + unit + "  " + ingredientName;
		if(!(this.pretreatment == null))
			result+=",  < " + pretreatment +" >";
		return result;
	}


	/**
	 * the toString function with time x and peopleAvailable
	 * 
	 * @param x times
	 * @return the content of the ingredients with time x
	 */
	public String timesX(int x, int peopleAvailable) {
		String result;
		result = ((double)quantity/peopleAvailable) * x + " " + unit + " " + ingredientName;
		if(!(this.pretreatment == null))
			result+=",  < " + pretreatment +" >";
		return result;
	}
	
}
