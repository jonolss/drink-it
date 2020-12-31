package se.slyntan.applications.controller.storage.clients;

import se.slyntan.applications.controller.exceptions.StorageReadException;
import se.slyntan.applications.controller.exceptions.StorageWriteException;

public interface StorageClient {

    public void writeToStorage(String fileName, String data) throws StorageWriteException;

    public String readFromStorage(String fileName) throws StorageReadException;
}
