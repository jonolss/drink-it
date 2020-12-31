package se.slyntan.applications.model.containers;

import se.slyntan.applications.model.models.Cocktail;

import java.util.*;

public class CocktailLibrary {

    private static Map<String, Cocktail> knownCocktails;

    public CocktailLibrary() {
        if(knownCocktails == null) {
            knownCocktails = new HashMap<>();
        }
    }

    public static void initLibrary() {
        if(knownCocktails == null) {
            knownCocktails = new HashMap<>();
        }
    }

    public static void resetLibrary() {
        knownCocktails = new HashMap<>();
    }

    public static void importLibrary(List<Cocktail> input) throws NullPointerException {
        input.forEach(CocktailLibrary::addCocktail);
    }

    public static List<Cocktail> exportLibrary() throws NullPointerException {
        List<Cocktail> output = new ArrayList(knownCocktails.values());
        output.sort(Comparator.comparing(Cocktail::getName));
        return output;
    }

    public static Cocktail fetchCocktail(String name) throws NullPointerException {
        return knownCocktails.get(name);
    }

    public static boolean addCocktail(Cocktail newCocktail) throws NullPointerException {
        Cocktail oldValue = knownCocktails.putIfAbsent(newCocktail.getName(), newCocktail);
        return oldValue == null;
    }

    public static void removeCocktail(String cocktailName) {
        try {
            knownCocktails.remove(cocktailName);
        } catch (NullPointerException e) {
            ;
        }
    }
}
