package se.slyntan.applications.controller.parsers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import se.slyntan.applications.model.models.Ingredient;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IngredientParserTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void parseIngredient() throws Exception {
        Ingredient sugar = new Ingredient("sugar");
        Ingredient lemon = new Ingredient("lemon");

        Ingredient lemon2 = new Ingredient("lemon");

        String json = mapper.writeValueAsString(Arrays.asList(sugar, lemon));

        List<Ingredient> result = IngredientParser.parseToListOfIngredients(json);

        assertEquals(2, result.size());
        assertTrue(result.containsAll(Arrays.asList(sugar,lemon)));

        assertTrue("Asserts that two identicial ingredience are treated as equal",result.contains(lemon2));
    }


}
