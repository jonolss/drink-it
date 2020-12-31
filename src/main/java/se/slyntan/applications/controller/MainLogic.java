package se.slyntan.applications.controller;

import se.slyntan.applications.controller.exceptions.StorageReadException;
import se.slyntan.applications.controller.exceptions.StorageWriteException;
import se.slyntan.applications.controller.storage.CocktailsStorageHandler;
import se.slyntan.applications.controller.storage.IngredientsStorageHandler;
import se.slyntan.applications.model.containers.CocktailLibrary;
import se.slyntan.applications.model.containers.KnownIngredients;

public class MainLogic {

    private static IngredientsStorageHandler ingredientsImporter;
    private static CocktailsStorageHandler cocktailsImporter;

    private static final String COCKTAILS_FILE_NAME = "cocktails.json";
    private static final String INGREDIENTS_FILE_NAME = "ingredients.json";

    public static void init() {
        CocktailLibrary.initLibrary();
        KnownIngredients.initLibrary();

        if (ingredientsImporter == null) {
            ingredientsImporter = new IngredientsStorageHandler();
        }

        if (cocktailsImporter == null) {
            cocktailsImporter = new CocktailsStorageHandler();
        }

        fillLibraries();
    }

    private static void fillLibraries() {
        try {
            CocktailLibrary.importLibrary(cocktailsImporter.importCocktails(COCKTAILS_FILE_NAME));
            KnownIngredients.importLibrary(ingredientsImporter.importIngredients(INGREDIENTS_FILE_NAME));
        } catch (StorageReadException e) {
            System.out.println("Failed to create needed libraries.");
        }

    }

}
