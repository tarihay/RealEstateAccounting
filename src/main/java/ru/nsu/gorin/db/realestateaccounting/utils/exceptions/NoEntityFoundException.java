package ru.nsu.gorin.db.realestateaccounting.utils.exceptions;

public class NoEntityFoundException extends RuntimeException {
    public NoEntityFoundException(String message) {
        super(message);
    }

    public NoEntityFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
