package teste1;

public final class Rental {
    private final Vehicle vehicle;
    private final String customer;

    /**
     * Constructs a new rental for the specified vehicle and customer.
     * @param vehicle The vehicle to rent.
     * @param customer The name of the customer renting the vehicle.
     * @throws RentalException If there is an issue with the rental process.
     */
    public Rental(Vehicle vehicle,String customer) throws RentalException {
        vehicle.rent();
        this.vehicle = vehicle;
        this.customer = customer;
    }

    /**
     * Returns the customer associated with this rental.
     * @return The customer name.
     */
    public String getCustomer() { return customer; }

    /**
     * Concludes the rental of the vehicle and returns the total cost for the rental period. The vehicle must remain unchanged if the rental conclusion fails (i.e., if an exception is thrown during the cost calculation).
     * @param days The number of days to calculate the rental cost for. Must be a non-negative integer.
     * @return The total cost for the rental period.
     * @throws RentalException If the vehicle is not rented or if there is an issue with the rental conclusion.
     */
    public double concludeRental(int days) throws RentalException {
        double cost = vehicle.calculateRental(days);
        vehicle.returnVehicle(); // Vehicle is returned and marked as available only if calculateRental does not throw an exception
        return cost;
    }

    /**
     * Calculates the rental cost for a vehicle for a single day.
     * @param vehicle The vehicle for which to calculate the rental cost.
     * @return The rental cost for one day.
     */
    public static double calculateRentalPerDay(Vehicle vehicle) {
        return vehicle.calculateRental(1);
    }
}
