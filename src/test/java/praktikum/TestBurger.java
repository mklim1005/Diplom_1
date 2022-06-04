package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    @Mock
    Bun bun;
    @Mock
    Ingredient meat;
    @Mock
    Ingredient salad;
    @Mock
    Ingredient cheeseSauce;

    @Test
    public void testBurgerAddIngredient() {
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING, "my test meat", 70);

        burger.addIngredient(meat);

        assertEquals(1, burger.ingredients.size());
        assertEquals(burger.ingredients.get(0).getType(), IngredientType.FILLING);
        assertEquals(burger.ingredients.get(0).getName(), "my test meat");
        assertEquals(burger.ingredients.get(0).getPrice(), 70, 0.0f);
    }

    @Test
    public void testBurgerRemoveIngredient() {
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING, "meat", 70);
        burger.addIngredient(meat);

        burger.removeIngredient(0);

        assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void testBurgerMoveIngredient() {
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING, "meat", 70);
        Ingredient salad = new Ingredient(IngredientType.FILLING, "salad", 20);
        burger.addIngredient(meat);
        burger.addIngredient(salad);

        burger.moveIngredient(1, 0);

        assertEquals(2, burger.ingredients.size());
        assertEquals(burger.ingredients.get(0), salad);
        assertEquals(burger.ingredients.get(1), meat);
    }

    @Test
    public void testPriceWithoutIngredients() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1000f);
        burger.setBuns(bun);

        float price = burger.getPrice();

        assertEquals(2000, price, 0.0f);
    }

    @Test(expected = NullPointerException.class)
    public void testBurgerGetPriceWithoutBun_ShouldThrowException() {
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING, "meat", 50);
        Ingredient salad = new Ingredient(IngredientType.FILLING, "salad", 20);
        Ingredient cheeseSauce = new Ingredient(IngredientType.SAUCE, "cheeseSauce", 10);
        burger.addIngredient(meat);
        burger.addIngredient(salad);
        burger.addIngredient(cheeseSauce);

        burger.getPrice();
    }

    @Test
    public void testBurgerGetPrice() {
        Burger burger = new Burger();
        Mockito.when(bun.getPrice()).thenReturn(1000f);
        burger.setBuns(bun);
        Mockito.when(meat.getPrice()).thenReturn(50f);
        Mockito.when(salad.getPrice()).thenReturn(-20f);
        Mockito.when(cheeseSauce.getPrice()).thenReturn(10f);
        burger.addIngredient(meat);
        burger.addIngredient(salad);
        burger.addIngredient(cheeseSauce);

        float price = burger.getPrice();

        assertEquals(2040, price, 0.0f);
    }

    @Test
    public void testBurgerGetReceipt() {
        Burger burger = new Burger();
        Bun bun = new Bun("Super Bun", 40);
        burger.setBuns(bun);
        Ingredient meat = new Ingredient(IngredientType.FILLING, "meat", 70);
        Ingredient salad = new Ingredient(IngredientType.FILLING, "salad", 20);
        Ingredient cheeseSauce = new Ingredient(IngredientType.SAUCE, "cheeseSauce", 10);
        burger.addIngredient(meat);
        burger.addIngredient(salad);
        burger.addIngredient(cheeseSauce);

        String receipt = burger.getReceipt();

        assertEquals("(==== Super Bun ====)\n" +
                "= filling meat =\n" +
                "= filling salad =\n" +
                "= sauce cheeseSauce =\n" +
                "(==== Super Bun ====)\n" +
                "\n" +
                "Price: 180.000000\n", receipt);
    }
}
