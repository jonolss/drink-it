package se.slyntan.applications.controller.storage;

import se.slyntan.applications.controller.parsers.CocktailParser;
import se.slyntan.applications.controller.storage.clients.LocalFileClient;
import se.slyntan.applications.controller.storage.clients.StorageClient;
import se.slyntan.applications.model.models.Cocktail;

import java.util.List;

public class ImportCocktails {

    private StorageClient storageClient;

    public ImportCocktails () {
        storageClient = new LocalFileClient();
    }

    public List<Cocktail> importCocktails(String fileName) {
        String data = storageClient.readFromStorage(fileName);
        return CocktailParser.parseToListOfCocktails(data);
    }

}
