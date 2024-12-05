package pluralsight;

import java.io.*;

public class DealershipFileManager {
    static String filePath = "inventory.csv";

    public Dealership getDealership() throws IOException {
    Dealership dealership = new Dealership("", "", "");

             BufferedReader bufReader = new BufferedReader(new FileReader(filePath));
            //create an array to separate the data in the csv

            String csvLine;
            while ((csvLine = bufReader.readLine()) != null) {
                String[] dataArray = csvLine.split("\\|");
                if (dataArray.length == 3) {
                    String name = dataArray[0];
                    String address = dataArray[1];
                    String phone = dataArray[2];

                     dealership = new Dealership(name, address, phone);
                } if (dataArray.length == 8) {

                    int vin;
                    try {
                        vin = Integer.parseInt(dataArray[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("invalid number" + dataArray[0]);
                        continue;
                    }

                    int year;
                    try {
                        year = Integer.parseInt(dataArray[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("invalid number" + dataArray[1]);
                        continue;
                    }

                    String make = dataArray[2];
                    String model = dataArray[3];
                    String vehicleType = dataArray[4];
                    String color = dataArray[5];

                    int odometer;
                    try {
                        odometer = Integer.parseInt(dataArray[6]);
                    } catch (NumberFormatException e) {
                        System.out.println("invalid number" + dataArray[6]);
                        continue;
                    }

                    double price;
                    try {
                        price = Double.parseDouble(dataArray[7]);
                    } catch (NumberFormatException e) {
                        System.out.println("invalid number" + dataArray[7]);
                        continue;
                    }
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }bufReader.close();

            return dealership;
    }
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