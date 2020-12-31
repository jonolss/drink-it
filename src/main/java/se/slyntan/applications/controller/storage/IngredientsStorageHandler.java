package se.slyntan.applications.controller.storage;

import se.slyntan.applications.controller.exceptions.StorageReadException;
import se.slyntan.applications.controller.exceptions.StorageWriteException;
import se.slyntan.applications.controller.parsers.IngredientParser;
import se.slyntan.applications.controller.storage.clients.LocalFileClient;
import se.slyntan.applications.controller.storage.clients.StorageClient;
import se.slyntan.applications.model.models.Cocktail;
import se.slyntan.applications.model.models.Ingredient;

import java.util.List;

public class IngredientsStorageHandler {

    private StorageClient storageClient;

    public IngredientsStorageHandler() {
        storageClient = new LocalFileClient();
    }

    public List<Ingredient> importIngredients(String fileName) throws StorageReadException {
        String data = null;
        data = storageClient.readFromStorage(fileName);
        return IngredientParser.parseToListOfIngredients(data);
    }

    public void exportIngredients(String fileName, List<Ingredient> data) throws StorageWriteException {
        String json = IngredientParser.parseListOfIngredientsToJson(data);
        storageClient.writeToStorage(fileName, json);
    }

}
