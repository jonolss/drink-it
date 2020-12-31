package se.slyntan.applications.controller.parsers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import se.slyntan.applications.model.models.Cocktail;

import java.util.List;

public class CocktailParser {

    private static ObjectMapper mapper = new ObjectMapper();

    public static List<Cocktail> parseJsonToListOfCocktails(String input) {
        List<Cocktail> cocktails = null;
        try {
            cocktails = mapper.readValue(input, new TypeReference<List<Cocktail>>() {});
        } catch (JsonProcessingException e) {
            System.out.println("Failed to process json to cocktails in CocktailParser");
        }
        return cocktails;
    }

    public static String parseListOfCocktailsToJson(List<Cocktail> input) {
        String json = "";
        try {
            json = mapper.writeValueAsString(input);
        } catch (JsonProcessingException e) {
            System.out.println("Failed to process cocktails to json in CocktailParser");
        }
        return json;
    }
}
