package food;

import java.util.Map;

public class Meal {

	private String name;
	private Map<Food, Double> ingredients;
	
	public Meal(String name, Map<Food, Double> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Map<Food, Double> getIngredients() {
		return this.ingredients;
	}
	
	public double getCalorificValue() {
		double calorificValue = 0;
		for(Map.Entry<Food, Double> entry : this.ingredients.entrySet()) {
			calorificValue += entry.getKey().relativeEnergyDensity() * entry.getValue();
		}
		return calorificValue;
	}
}
