package se.slyntan.applications.controller.exceptions;

public class StorageWriteException extends Exception{
    public StorageWriteException(String errorMessage) {
        super(errorMessage);
    }
}
