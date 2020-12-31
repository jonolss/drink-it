package se.slyntan.applications.controller.storage;

import se.slyntan.applications.controller.exceptions.StorageReadException;
import se.slyntan.applications.controller.exceptions.StorageWriteException;
import se.slyntan.applications.controller.parsers.CocktailParser;
import se.slyntan.applications.controller.storage.clients.LocalFileClient;
import se.slyntan.applications.controller.storage.clients.StorageClient;
import se.slyntan.applications.model.models.Cocktail;

import java.util.List;

public class CocktailsStorageHandler {

    private StorageClient storageClient;

    public CocktailsStorageHandler() {
        storageClient = new LocalFileClient();
    }

    public List<Cocktail> importCocktails(String fileName) throws StorageReadException {
        String data = null;
        data = storageClient.readFromStorage(fileName);
        return CocktailParser.parseJsonToListOfCocktails(data);
    }

    public void exportCocktails(String fileName, List<Cocktail> data) throws StorageWriteException {
        String json = CocktailParser.parseListOfCocktailsToJson(data);
        storageClient.writeToStorage(fileName, json);
    }

}
