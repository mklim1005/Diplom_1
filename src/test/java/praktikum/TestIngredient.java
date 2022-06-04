package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestIngredient {

    @Test
    public void testIngredientGetPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Space Sauce", 60.02f);
        assertEquals(60.02f, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testIngredientGetPrice_NegativePriceAllowed() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Space Sauce", -60.02f);
        assertEquals(-60.02f, ingredient.getPrice(), 0.0f);
    }

    @Test
    public void testIngredientGetName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "Space Sauce", 60);
        assertEquals("Space Sauce", ingredient.getName());
    }

    @Test
    public void testIngredientGetType() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Space Sauce", 60);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
}
