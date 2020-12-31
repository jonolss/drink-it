package se.slyntan.applications.controller.storage.clients;

import se.slyntan.applications.controller.exceptions.StorageReadException;
import se.slyntan.applications.controller.exceptions.StorageWriteException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LocalFileClient implements StorageClient {


    @Override
    public void writeToStorage(String fileName, String data) throws StorageWriteException {
        Path path = Path.of(fileName);
        try {
            Files.writeString(path, data);
        } catch (IOException e) {
            System.out.println("Could not write to file with filename: " + fileName);
            throw new StorageWriteException("Could not write to file with filename: " + fileName);
        }
    }

    @Override
    public String readFromStorage(String fileName) throws StorageReadException {
        Path path = Path.of(fileName);
        String fromFile;
        try {
            fromFile = Files.readString(path);
        } catch (IOException e) {
            System.out.println("Could not read from file with filename: " + fileName);
            throw new StorageReadException("Could not read from file with filename: " + fileName);
        }

        if(fromFile == null || fromFile.isEmpty()) {
            System.out.println("The file was empty. Filename: " + fileName);
            throw new StorageReadException("The file was empty. Filename: " + fileName);
        }

        return fromFile;
    }
}
