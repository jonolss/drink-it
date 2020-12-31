package se.slyntan.applications.controller.storage;

import org.junit.Test;
import se.slyntan.applications.controller.exceptions.StorageReadException;
import se.slyntan.applications.model.models.Cocktail;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static se.slyntan.applications.utils.CocktailTestUtil.createBaseListOfCocktails;

public class CocktailsStorageHandlerTest {

    private final String TEST_FILENAME = "COCKTAILS_TEST.json";

    private final CocktailsStorageHandler cocktailsStorageHandler;

    public CocktailsStorageHandlerTest() {
        cocktailsStorageHandler = new CocktailsStorageHandler();
    }

    @Test
    public void exportAndImportTest() throws Exception {
        List<Cocktail> exportCocktails = createBaseListOfCocktails();

        cocktailsStorageHandler.exportCocktails(TEST_FILENAME, exportCocktails);

        List<Cocktail> importCocktails = cocktailsStorageHandler.importCocktails(TEST_FILENAME);

        assertEquals(exportCocktails.size(), importCocktails.size());
        assertTrue(exportCocktails.containsAll(importCocktails));
    }

    @Test(expected = StorageReadException.class)
    public void importNonExistingFileTest() throws Exception {
        cocktailsStorageHandler.importCocktails("NOT_A_FILE");
    }

}
