package lt.sda.utils;

import lt.sda.vehicleException.VehicleException;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter {

    public void writeToFile(String fileName, String content) throws VehicleException {

        try {
            Files.write(Paths.get("resources//" + fileName ), content.getBytes());
        } catch (Exception ex) {
            throw new VehicleException(ex.getMessage());
        }

    }
}
