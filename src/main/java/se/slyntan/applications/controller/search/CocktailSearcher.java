package se.slyntan.applications.controller.search;

import se.slyntan.applications.model.containers.CocktailLibrary;
import se.slyntan.applications.model.models.Cocktail;
import se.slyntan.applications.model.models.Ingredient;
import se.slyntan.applications.model.models.queries.Query;

import java.util.List;
import java.util.stream.Collectors;

public class CocktailSearcher {


    public static List<Cocktail> searchForMatchingCocktails(Query searchQuery) {
        return null;
    }

    public static List<Cocktail> searchForMatchingCocktails(List<Ingredient> mandatoryIngedients) {
        List<Cocktail> cocktailLibrary = CocktailLibrary.exportLibrary();
        return cocktailLibrary.stream()
                .filter(x -> x.evaluateSearchQuery(mandatoryIngedients))
                .collect(Collectors.toList());
    }

}
