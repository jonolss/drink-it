package se.slyntan.applications.controller.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.slyntan.applications.model.models.Cocktail;

import java.util.List;

public class CocktailParser {

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Cocktail> parseToListOfCocktails(String input) {
        List<Cocktail> cocktails = null;
        try {
            cocktails = mapper.readValue(input, new TypeReference<List<Cocktail>>() {});
        } catch (JsonProcessingException e) {
            System.out.println("Failed to process ingredients in IngredientParser");
        }
        return cocktails;
    }
}
