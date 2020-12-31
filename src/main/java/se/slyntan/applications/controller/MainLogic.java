package se.slyntan.applications.controller;

import se.slyntan.applications.controller.storage.ImportCocktails;
import se.slyntan.applications.controller.storage.ImportIngredients;
import se.slyntan.applications.model.containers.CocktailLibrary;
import se.slyntan.applications.model.containers.KnownIngredients;

public class MainLogic {

    private static ImportIngredients ingredientsImporter;
    private static ImportCocktails cocktailsImporter;

    private static final String COCKTAILS_FILE_NAME = "cock.json";
    private static final String INGREDIENTS_FILE_NAME = "ingr.json";

    public static void init() {
        CocktailLibrary.initLibrary();
        KnownIngredients.initLibrary();

        if (ingredientsImporter == null) {
            ingredientsImporter = new ImportIngredients();
        }

        if (cocktailsImporter == null) {
            cocktailsImporter = new ImportCocktails();
        }

        fillLibraries();
    }

    private static void fillLibraries() {
        CocktailLibrary.importLibrary(cocktailsImporter.importCocktails(COCKTAILS_FILE_NAME));
        KnownIngredients.importLibrary(ingredientsImporter.importIngredients(INGREDIENTS_FILE_NAME));
    }

}
