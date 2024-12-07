package pluralsight;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class DealershipFileManager {
    static String filePath = "inventory.csv";


    public void saveDealership(Dealership dealership) {
        try {
            FileWriter writer = new FileWriter(filePath);
            BufferedWriter bufWriter = new BufferedWriter(writer);

            String dealershipToCsvLine;
            dealershipToCsvLine = String.format("%s|%s|%s\n", dealership.getName(), dealership.getAddress(), dealership.getPhone());
            bufWriter.write(dealershipToCsvLine);

            String vehicleToCsvLine;
            for (Vehicle v : dealership.getAllVehicles()) {
                vehicleToCsvLine = String.format("%d|%d|%s|%s|%s|%s|%d|%.2f\n", v.getVin(), v.getYear(), v.getMake(), v.getModel(), v.getVehicleType(), v.getColor(), v.getOdometer(), v.getPrice());
                bufWriter.write(vehicleToCsvLine);
            }
            bufWriter.close();
        } catch (IOException e) {
            System.out.println("Problem writing to file");
        }

    }

}