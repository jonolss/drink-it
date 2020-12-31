package se.slyntan.applications.model.containers;

import se.slyntan.applications.model.models.Ingredient;

import java.util.*;

public class KnownIngredients {

    private static Map<String, Ingredient> knownIngredients;

    public KnownIngredients() {
        if(knownIngredients == null) {
            knownIngredients = new HashMap<>();
        }
    }

    public static void initLibrary() {
        if(knownIngredients == null) {
            knownIngredients = new HashMap<>();
        }
    }

    public static void resetLibrary() {
        knownIngredients = new HashMap<>();
    }

    public static void importLibrary(List<Ingredient> input) throws NullPointerException {
        input.forEach(KnownIngredients::addIngredient);
    }

    public static List<Ingredient> exportLibrary() throws NullPointerException {
        List<Ingredient> output = new ArrayList(knownIngredients.values());
        output.sort(Comparator.comparing(Ingredient::getName));
        return output;
    }

    public static boolean addIngredient(Ingredient newIngredient) throws NullPointerException {
        Ingredient oldValue = knownIngredients.putIfAbsent(newIngredient.getName(), newIngredient);
        return oldValue == null;
    }

    public static void removeIngredient(String ingredientName) {
        try {
            knownIngredients.remove(ingredientName);
        } catch (NullPointerException e) {
            ;
        }
    }

}
