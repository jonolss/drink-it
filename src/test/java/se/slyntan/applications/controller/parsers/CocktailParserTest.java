package se.slyntan.applications.controller.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import se.slyntan.applications.model.models.Cocktail;
import se.slyntan.applications.model.models.CocktailIngredient;
import se.slyntan.applications.model.models.Ingredient;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CocktailParserTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void parseCocktails() throws Exception {
        Cocktail whiskySour = new Cocktail.Builder()
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
        Cocktail daiquiri = new Cocktail.Builder()
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

        Cocktail daiquiri2 = new Cocktail.Builder()
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

        String json = mapper.writeValueAsString(Arrays.asList(whiskySour, daiquiri));

        List<Cocktail> result = CocktailParser.parseToListOfCocktails(json);

        assertEquals(2, result.size());
        assertTrue(result.containsAll(Arrays.asList(whiskySour,daiquiri)));

        assertTrue("Asserts that two identicial ingredience are treated as equal",result.contains(daiquiri2));
    }
}
