package teste1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public final class Fleet {
    private final List<Vehicle> vehicles;
    private final List<Rental> rentals;

    /**
     * Initializes a new Fleet with the given vehicles and with an empty list of rentals.
     * @param vehicles A sequence of Vehicle objects to be added to the fleet.
     */
    public Fleet(Vehicle... vehicles) {
        this.vehicles = new ArrayList<>(Arrays.asList(vehicles));
        // Alternative to the Arrays.asList(vehicles):
//        this.vehicles = new ArrayList<>(vehicles.length);
//        for (Vehicle vehicle : vehicles) {
//            this.vehicles.add(vehicle);
//        }
        this.rentals = new ArrayList<>();
    }

    /**
     * Rents a vehicle to a customer.
     * @param vehicle The vehicle parameter may not be the same instance as the one in the fleet, but it must be equal to it (i.e., have the same license plate).
     * @param customer The name of the customer renting the vehicle.
     * @return The Rental object inserted in the fleet or null either if the vehicle is not found in the fleet or if it is already rented.
     */
    public Rental rentVehicle(Vehicle vehicle, String customer) {
        int idx = vehicles.indexOf(vehicle);
        if (idx == -1)
            return null; // Vehicle not found in the fleet
        Rental rental = null;
        try {
            rental = new Rental(vehicles.get(idx), customer);
            rentals.add(rental);
        } catch (RentalException _) {
        }
        return rental;
    }

    /**
     * Process the return back of a rented vehicle. Removes the rental from the list of active rentals and calculates the total cost based on the number of days rented.
     * @param rental The rental object representing the transaction.
     * @param days The number of days the vehicle was rented.
     * @return The total cost of the rental.
     * @throws IllegalArgumentException If the number of days is negative.
     * @throws RentalException If the rental is not found in the fleet.
     */
    public double returnVehicle(Rental rental, int days) throws RentalException {
        if (!rentals.contains(rental)) {
            throw new RentalException();
        }
        double cost = rental.concludeRental(days);
        rentals.remove(rental);
        return cost;
    }

    /**
     * Filters the vehicles in the fleet based on a given predicate.
     * @param filter A predicate that defines the filtering criteria for the vehicles.
     * @return A list of vehicles that match the filtering criteria.
     */
    private List<Vehicle> getVehicles(Predicate<Vehicle> filter) {
//        List<Vehicle> filteredVehicles = new ArrayList<>();
//        for (Vehicle vehicle : vehicles) {
//            if (filter.test(vehicle)) {
//                filteredVehicles.add(vehicle);
//            }
//        }
//        return filteredVehicles;
        // Alternative using Java Streams:
        return vehicles.stream().filter(filter).toList();
    }

    /**
     * Print to standard output all cargo vans that have a cargo capacity within the specified range. Must use getVehicles method to filter the vehicles.
     * @param minCapacity The minimum cargo capacity.
     * @param maxCapacity The maximum cargo capacity.
     */
    public void printCargoVansBetweenCapacity(int minCapacity, int maxCapacity) {
        Predicate<Vehicle> filter = v ->
                v instanceof CargoVan van &&
                van.getCargoCapacity() >= minCapacity && van.getCargoCapacity() <= maxCapacity;
        List<Vehicle> filteredVehicles = getVehicles(filter);
//        for (Vehicle vehicle : filteredVehicles) {
//            System.out.println(vehicle);
//        }
        // Alternative using method reference:
        filteredVehicles.forEach(System.out::println);
    }
}
