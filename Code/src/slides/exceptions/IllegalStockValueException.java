package exceptions;

public class IllegalStockValueException extends Exception {
    IllegalStockValueException() { super("Illegal stock value"); }
    IllegalStockValueException(String msg) { super(msg); }
}
