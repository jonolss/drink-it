package se.slyntan.applications.controller.storage.clients;

public interface StorageClient {

    public void writeToStorage(String fileName, String data);

    public String readFromStorage(String fileName);
}
