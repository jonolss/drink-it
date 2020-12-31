package se.slyntan.applications.utils;

import se.slyntan.applications.model.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class IngredientTestUtil {

    public static Ingredient createBasicIngredient() {
        return new Ingredient("lemon");
    }

    public static List<Ingredient> createBaseListOfIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("bourbon"));
        ingredients.add(new Ingredient("demerara_simple_syrup"));
        ingredients.add(new Ingredient("egg_white"));
        ingredients.add(new Ingredient("lemon"));
        ingredients.add(new Ingredient("light_rum"));
        ingredients.add(new Ingredient("lime"));
        ingredients.add(new Ingredient("simple_syrup"));
        return ingredients;
    }
}
