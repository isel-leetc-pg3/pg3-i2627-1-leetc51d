package teste1;

public class RentalException extends Exception {
    public RentalException(String message) { super(message); }
    public RentalException() { super("Rental failed"); }
}
