package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestIngredientParameterized {

    private final Ingredient ingredient;
    private final String name;
    private final IngredientType type;
    private final float price;

    public TestIngredientParameterized(Ingredient ingredient, IngredientType type, String name, float price) {
        this.ingredient = ingredient;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                { new Ingredient(IngredientType.SAUCE, "My Test Name", 30.01f), IngredientType.SAUCE, "My Test Name", 30.01f},
                { new Ingredient(IngredientType.FILLING, "      ", -0.01f), IngredientType.FILLING, "      ", -0.01f},
                { new Ingredient(IngredientType.FILLING, ":) ##+!$(:", 0), IngredientType.FILLING, ":) ##+!$(:", 0},
        };
    }

    @Test
    public void testIngredient() {
        assertEquals(ingredient.getType(), type);
        assertEquals(ingredient.getName(), name);
        assertEquals(ingredient.getPrice(), price, 0.0f);
    }
}
