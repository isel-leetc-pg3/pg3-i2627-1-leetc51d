package teste1;

public abstract class Vehicle implements Rentable {
    private final String licensePlate;
    private boolean isAvailable;

    /**
     * Constructs a Vehicle with the given license plate. The constructed vehicle is available for rent.
     * @param licensePlate the license plate of the vehicle
     */
    public Vehicle(String licensePlate) {
        this.licensePlate = licensePlate;
        this.isAvailable = true;
    }

    /**
     * Rents the vehicle. If the vehicle is already rented, a RentalException is thrown with the message "Vehicle is already rented".
     * @throws RentalException if the vehicle is already rented
     */
    @Override
    public final void rent() throws RentalException {
        if (!isAvailable) {
            throw new RentalException("Vehicle is already rented");
        }
        isAvailable = false;
    }

    /**
     * Returns the vehicle. If the vehicle is not rented, a RentalException is thrown with the message "Vehicle is not rented".
     * @throws RentalException if the vehicle is not rented
     */
    @Override
    public final void returnVehicle() throws RentalException {
        if (isAvailable) {
            throw new RentalException("Vehicle is not rented");
        }
        isAvailable = true;
    }
    /**
     * Calculates the rental cost for the given number of days. Throws an IllegalArgumentException with the message "Days cannot be negative" if the number of days is negative.
     * @param days the number of days for which to calculate the rental cost
     * @return the rental cost
     * @throws IllegalArgumentException if the number of days is negative
     */
    public final double calculateRental(int days) {
        if (days < 0)
            throw new IllegalArgumentException("Days cannot be negative");
        return getDailyRate() * days;
    }

    /**
     * Returns the daily rental rate for the vehicle. This method must be implemented by subclasses to provide the specific daily rate for each type of vehicle.
     * @return the daily rental rate
     */
    protected abstract double getDailyRate();

    /**
     * Compares this vehicle with another object for equality. Two vehicles are considered equal if they have the same license plate.
     * @param other   the reference object with which to compare.
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Vehicle v) {
            return this.licensePlate.equals(v.licensePlate);
        }
        return false;
    }

    /**
     * Returns a string representation of the vehicle, including its license plate and availability status.
     * @return a string representation of the vehicle
     */
    public String toString() {
        return "Vehicle{licensePlate=\"" + licensePlate + "\", isAvailable=" + isAvailable + '}';
    }
}
