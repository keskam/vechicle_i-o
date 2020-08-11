package lt.sda.utils;

import lt.sda.model.Cars;
import lt.sda.model.Motorcycles;
import lt.sda.model.Tractors;
import lt.sda.vehicleException.VehicleException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class ObjectCreationHelper {

    private final Path path = Paths.get("resources\\vehicles.txt");
    private VehicleUtils vehicleUtils = new VehicleUtils();

    public VehicleUtils getVehicleUtils() {
        return vehicleUtils;
    }

    public void createObjectsFromFile() throws VehicleException {
        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(l -> createJavaObjects(l));
        } catch (Exception ex) {
            throw new VehicleException(ex.getMessage());
        }
    }

    private void createJavaObjects(String line) {
        String[] lineArray = Arrays.stream(line.split(",")).map(String::trim).toArray(String[]::new);
        switch (lineArray[0]) {
            case("Car"):
                Cars car = new Cars(lineArray[1], lineArray[2], parseInteger(lineArray[3]), parseInteger(lineArray[4]), lineArray[5], lineArray[6]);
                vehicleUtils.addVehicleToList(car);
                break;
            case("Motorcycle"):
                Motorcycles motorcycle = new Motorcycles(lineArray[1], lineArray[2], parseInteger(lineArray[3]), parseInteger(lineArray[4]), lineArray[5]);
                vehicleUtils.addVehicleToList(motorcycle);
                break;
            case("Tractor"):
                Tractors tractor = new Tractors(lineArray[1], lineArray[2], parseInteger(lineArray[3]), parseInteger(lineArray[4]));
                vehicleUtils.addVehicleToList(tractor);
                break;
            default:
                System.out.println("Wrong type");
        }
    }

    private int parseInteger(String integer) {
        try {
            return Integer.parseInt(integer);
        } catch (NumberFormatException ex) {
            return -1;
        }
    }
}
