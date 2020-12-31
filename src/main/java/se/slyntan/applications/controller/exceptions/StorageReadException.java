package se.slyntan.applications.controller.exceptions;

public class StorageReadException extends Exception{
    public StorageReadException(String errorMessage) {
        super(errorMessage);
    }
}