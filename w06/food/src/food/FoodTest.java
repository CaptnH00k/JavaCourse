package food;

import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;

public class FoodTest {
	@Test
	public void testMeal() {
		Map<Food, Double> ingredients = new HashMap<>();
		ingredients.put(new Food("Water", 0.0, 0.0, 0.0), 1000.0);
		ingredients.put(new Food("Sugar", 1.0, 0.0, 0.0), 100.0);
		ingredients.put(new Food("Protein", 0.0, 0.0, 1.0), 100.0);
		Meal shake = new Meal("Fitness-Shake", ingredients);
		assertEquals(3400.0, shake.getCalorificValue(), 0.0001);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testIllegalFood() {
		new Food("Burger", 1, 1, 1);
	}
	
	@Test
	public void testFoodGetName() {
		Food f = new Food("fourtytwo", 0.1, 0.2, 0.3);
		assertEquals(f.getName(), "fourtytwo");
	}
	
	@Test
	public void testFoodEquals() {
		Food f1 = new Food("fourtytwo", 0.1, 0.2, 0.3);
		Food f2 = new Food("fourtythree", 0.1, 0.2, 0.3);
		assertEquals(f1.equals(f1), true);
		assertEquals(f1.equals(f2), false);
	}
}