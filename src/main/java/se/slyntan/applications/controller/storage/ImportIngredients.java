package se.slyntan.applications.controller.storage;

import se.slyntan.applications.controller.parsers.IngredientParser;
import se.slyntan.applications.controller.storage.clients.LocalFileClient;
import se.slyntan.applications.controller.storage.clients.StorageClient;
import se.slyntan.applications.model.models.Ingredient;

import java.util.List;

public class ImportIngredients {

    private StorageClient storageClient;

    public ImportIngredients () {
        storageClient = new LocalFileClient();
    }

    public List<Ingredient> importIngredients(String fileName) {
        String data = storageClient.readFromStorage(fileName);
        return IngredientParser.parseToListOfIngredients(data);
    }


}
