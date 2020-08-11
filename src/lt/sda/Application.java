package lt.sda;

import lt.sda.utils.FileWriter;
import lt.sda.utils.ObjectCreationHelper;
import lt.sda.utils.VehicleUtils;
import lt.sda.model.Cars;
import lt.sda.model.Motorcycles;
import lt.sda.model.Tractors;
import lt.sda.model.Vehicle;
import lt.sda.vehicleException.VehicleException;

import java.util.List;

public class Application {

    public static void main(String[] args) throws VehicleException {

        ObjectCreationHelper objectCreationHelper = new ObjectCreationHelper();
        objectCreationHelper.createObjectsFromFile();

        VehicleUtils vehicleUtils = objectCreationHelper.getVehicleUtils();

        System.out.println("Vehicle List size: " + vehicleUtils.countVehiclesSize());
        System.out.println("Cars in the list: " + vehicleUtils.countVehiclesByType(Cars.class));
        System.out.println("Motorcycles in the list: " + vehicleUtils.countVehiclesByType(Motorcycles.class));
        System.out.println("Tractors in the list: " + vehicleUtils.countVehiclesByType(Tractors.class));

        System.out.println("Mercedes in the list: " + vehicleUtils.countVehiclesByBrand("Mercedes"));
        System.out.println("BMW in the list: " + vehicleUtils.countVehiclesByBrand("BMW"));

        vehicleUtils.sortByPrice();

        System.out.println("Print all cars details");
        List<Vehicle> vehicleArrayList = vehicleUtils.getListOfVehiclesByType(Cars.class);
        FileWriter fileWriter = new FileWriter();
        fileWriter.writeToFile("Cars.txt", vehicleArrayList.toString());

        for(Vehicle vehicle: vehicleUtils.getListOfVehiclesByType(Cars.class)) {
            System.out.println(vehicle.toString());
        }

    }
}
