package Exceptions;

public class StockUnavailableException extends Exception {
    public StockUnavailableException(String message) {
        super(message);
    }
}