package teste1;

public class CargoVan extends Vehicle {
    /**
     * The daily rental rate for a CargoVan is $80.00, with an additional fee based on the cargo capacity.
     */
    public static final double DAILY_RATE = 80.0;
    /**
     * The cargo capacity fee is calculated as 1% of the cargo capacity in liters. For example, if the cargo capacity is 1000 liters, the additional fee would be $10.00 (1000 * 0.01).
     */
    public static final double CARGO_CAPACITY_FEE = 0.01; // 1% fee for cargo capacity
    private final int cargoCapacity; // capacity in liters

    public CargoVan(String licensePlate, int cargoCapacity) {
        super(licensePlate);
        this.cargoCapacity = cargoCapacity;
    }

    /**
     * Calculates the daily rental rate for the cargo van, which is the base daily rate plus an additional fee based on the cargo capacity.
     * @return the daily rental rate
     */
    @Override
    protected double getDailyRate() {
        return DAILY_RATE + cargoCapacity * CARGO_CAPACITY_FEE;
    }
    /**
     * Returns the cargo capacity of the cargo van.
     * @return the cargo capacity in liters
     */
    public int getCargoCapacity() { return cargoCapacity; }
    /**
     * Returns a string representation of the cargo van, including its cargo capacity and vehicle details.
     * @return a string representation of the cargo van
     */
    public String toString() {
        return "CargoVan{cargoCapacity=" + cargoCapacity + ", " + super.toString() + '}';
    }
}
