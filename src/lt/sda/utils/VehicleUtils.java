package lt.sda.utils;

import lt.sda.model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleUtils {

    private List<Vehicle> vehicleList = new ArrayList<>();

    public void addVehicleToList(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    public int countVehiclesSize() {
        return vehicleList.size();
    }

    public int countVehiclesByType(Class vehicle) {
        return (int) vehicleList.stream()
                .filter(vehicle::isInstance)
                .count();
    }

    public List<Vehicle> getListOfVehiclesByType(Class vehicle) {
        return vehicleList.stream()
                .filter(vehicle::isInstance)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public int countVehiclesByBrand(String brand) {
        return (int) vehicleList.stream()
                .filter(vehicle -> vehicle.getBrand().equals(brand))
                .count();
    }

    public void sortVehiclesByPrice() {
        vehicleList.stream()
                .sorted(Comparator.comparingInt(Vehicle::getPrice))
                .forEach(System.out::println);
    }

    public void sortByPrice() {
        vehicleList.stream()
                .sorted(Vehicle::compareTo)
                .forEach(System.out::println);
    }
}
