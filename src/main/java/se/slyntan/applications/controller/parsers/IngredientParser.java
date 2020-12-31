package se.slyntan.applications.controller.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.slyntan.applications.model.models.Cocktail;
import se.slyntan.applications.model.models.Ingredient;

import java.util.List;

public class IngredientParser {

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Ingredient> parseToListOfIngredients(String input) {
        List<Ingredient> ingredient = null;
        try {
            ingredient = mapper.readValue(input, new TypeReference<List<Ingredient>>() {});
        } catch (JsonProcessingException e) {
            System.out.println("Failed to process ingredients in IngredientParser");
        }
        return ingredient;
    }

    public static String parseListOfIngredientsToJson(List<Ingredient> input) {
        String json = "";
        try {
            json = mapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to process json to ingredients in IngredientParser");
        }
        return json;
    }

}
