package se.slyntan.applications.controller.storage;

import org.junit.Test;
import se.slyntan.applications.controller.exceptions.StorageReadException;
import se.slyntan.applications.model.models.Cocktail;
import se.slyntan.applications.model.models.Ingredient;
import se.slyntan.applications.utils.IngredientTestUtil;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static se.slyntan.applications.utils.IngredientTestUtil.createBaseListOfIngredients;

public class IngredientsStorageHandlerTest {

    private final String TEST_FILENAME = "INGREDIENTS_TEST.json";

    private final IngredientsStorageHandler ingredientsStorageHandler;

    public IngredientsStorageHandlerTest() {
        ingredientsStorageHandler = new IngredientsStorageHandler();
    }

    @Test
    public void exportAndImportTest() throws Exception {
        List<Ingredient> exportIngredients = createBaseListOfIngredients();

        ingredientsStorageHandler.exportIngredients(TEST_FILENAME, exportIngredients);

        List<Ingredient> importIngredients = ingredientsStorageHandler.importIngredients(TEST_FILENAME);

        assertEquals(exportIngredients.size(), importIngredients.size());
        assertTrue(exportIngredients.containsAll(importIngredients));
    }

    @Test(expected = StorageReadException.class)
    public void importNonExistingFileTest() throws Exception {
        ingredientsStorageHandler.importIngredients("NOT_A_FILE");
    }

}
