package se.slyntan.applications.utils;

import se.slyntan.applications.model.models.Cocktail;
import se.slyntan.applications.model.models.CocktailIngredient;
import se.slyntan.applications.model.models.Ingredient;

import java.util.Arrays;
import java.util.List;

public class CocktailTestUtil {

    public static List<Cocktail> createBaseListOfCocktails() {
        return Arrays.asList(createDaiquiriCocktail(), createWhiskySourCocktail());
    }

    public static Cocktail createBasicCocktail() {
        return createWhiskySourCocktail();
    }

    public static Cocktail createWhiskySourCocktail() {
        return new Cocktail.Builder()
                .withName("whisky_sour")
                .withCocktailIngredient(new CocktailIngredient.Builder()
                        .withIngredient(new Ingredient("bourbon"))
                        .withAmount("2oz")
                        .build())
                .withCocktailIngredient(new CocktailIngredient.Builder()
                        .withIngredient(new Ingredient("lemon"))
                        .withAmount("1oz")
                        .build())
                .withCocktailIngredient(new CocktailIngredient.Builder()
                        .withIngredient(new Ingredient("simple_syrup"))
                        .withAmount("0.52oz")
                        .build())
                .withCocktailIngredient(new CocktailIngredient.Builder()
                        .withIngredient(new Ingredient("egg_white"))
                        .withAmount("1")
                        .build())
                .build();
    }

    public static Cocktail createDaiquiriCocktail() {
        return new Cocktail.Builder()
                .withName("whisky_sour")
                .withCocktailIngredient(new CocktailIngredient.Builder()
                        .withIngredient(new Ingredient("light_rum"))
                        .withAmount("2oz")
                        .build())
                .withCocktailIngredient(new CocktailIngredient.Builder()
                        .withIngredient(new Ingredient("lime"))
                        .withAmount("1oz")
                        .build())
                .withCocktailIngredient(new CocktailIngredient.Builder()
                        .withIngredient(new Ingredient("demerara_simple_syrup"))
                        .withAmount("0.75oz")
                        .build())
                .build();
    }

}
