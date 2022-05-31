package praktikum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestBurger {

    @Test
    public void testBurgerAddIngredient(){
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING,"meat",70);
        burger.addIngredient(meat);
        assertTrue(burger.ingredients.get(0) == meat);
    }

    @Test
    public void testBurgerRemoveIngredient(){
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING,"meat",70);
        burger.addIngredient(meat);
        burger.removeIngredient(0);
        assertTrue(burger.ingredients.isEmpty());
    }
    @Test
    public void testBurgerMoveIngredient(){
        Burger burger = new Burger();
        Ingredient meat = new Ingredient(IngredientType.FILLING,"meat",70);
        Ingredient salad = new Ingredient(IngredientType.FILLING,"salad",20);
        burger.addIngredient(meat);
        burger.addIngredient(salad);
        burger.moveIngredient(1,0);
        assertTrue(burger.ingredients.get(0)==salad && burger.ingredients.get(1)==meat);
    }



}
