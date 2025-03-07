package org.skypro.skyshop.search;

public class BestResultNotFound extends RuntimeException { // Изменено на RuntimeException
    public BestResultNotFound(String message) {
        super(message);
    }
}