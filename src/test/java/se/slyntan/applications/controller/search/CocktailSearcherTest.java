package se.slyntan.applications.controller.search;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.slyntan.applications.model.containers.CocktailLibrary;
import se.slyntan.applications.model.models.Cocktail;
import se.slyntan.applications.model.models.CocktailIngredient;
import se.slyntan.applications.model.models.Ingredient;
import se.slyntan.applications.utils.CocktailTestUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CocktailSearcherTest {

    @BeforeClass
    public static void init() {
        CocktailLibrary.initLibrary();
    }

    @Before
    public void setup() {
        CocktailLibrary.addCocktail(CocktailTestUtil.createDaiquiriCocktail());
        CocktailLibrary.addCocktail(CocktailTestUtil.createWhiskySourCocktail());
        CocktailLibrary.addCocktail(CocktailTestUtil.createSidecarCocktail());
    }

    @After
    public void cleanup() {
        CocktailLibrary.resetLibrary();
    }

    @Test
    public void findOneCocktailUsingOneIngredient() {
        Ingredient ingredient = new Ingredient("lime");

        List<Cocktail> result = CocktailSearcher.searchForMatchingCocktails(Collections.singletonList(ingredient));

        assertEquals(1, result.size());
        for(Cocktail cocktail : result) {
            assertTrue(cocktail.getCocktailIngredients().stream().map(CocktailIngredient::getIngredient).anyMatch(x -> x.equals(ingredient)));
        }
    }

    @Test
    public void findTwoCocktailsUsingOneIngredient() {
        Ingredient ingredient = new Ingredient("lemon");

        List<Cocktail> result = CocktailSearcher.searchForMatchingCocktails(Collections.singletonList(ingredient));

        assertEquals(2, result.size());
        for(Cocktail cocktail : result) {
            assertTrue(cocktail.getCocktailIngredients().stream().map(CocktailIngredient::getIngredient).anyMatch(x -> x.equals(ingredient)));
        }
    }

    @Test
    public void cantFindCocktailUsingOneIngredient() {
        Ingredient ingredient = new Ingredient("orange");

        List<Cocktail> result = CocktailSearcher.searchForMatchingCocktails(Collections.singletonList(ingredient));

        assertEquals(0, result.size());
    }

    @Test
    public void findCocktailUsingMultipleIngredient() {
        List<Ingredient> ingredients = Arrays.asList(new Ingredient("lime"), new Ingredient("lemon"));

        List<Cocktail> result = CocktailSearcher.searchForMatchingCocktails(ingredients);
        assertEquals(3, result.size());
        for(Cocktail cocktail : result) {
            assertTrue(cocktail.getCocktailIngredients().stream()
                    .map(CocktailIngredient::getIngredient)
                    .anyMatch(ingredients::contains));
        }
    }

    @Test
    public void cantFindCocktailUsingMultipleIngredient() {
        List<Ingredient> ingredients = Arrays.asList(new Ingredient("orange"), new Ingredient("vodka"));

        List<Cocktail> result = CocktailSearcher.searchForMatchingCocktails(ingredients);

        assertEquals(0, result.size());
    }

}








