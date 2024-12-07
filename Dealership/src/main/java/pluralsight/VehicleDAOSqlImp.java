package pluralsight;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAOSqlImp implements VehicleDAO{
    private DataSource ds;
    public VehicleDAOSqlImp (DataSource ds) {
        this.ds = ds;
    }


    @Override
    public List<Vehicle> findByColor(String color) {
        List<Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE color = ?");
            ps.setString(1, color);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {

        }
        return vehicleList;
    }


    @Override
    public List<Vehicle> findByMileage(int min, int max) {
        List<Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE odometer BETWEEN ? AND ?;");
            ps.setInt(1,min);
            ps.setInt(2, max);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {

        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findByVehicleType(String type) {
        List<Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE vehicle_type = ?");
            ps.setString(1, type);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {

        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles;");
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findByPrice(double min, double max) {
        List<Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE price BETWEEN ? AND ?;");
            ps.setDouble(1, min);
            ps.setDouble(2, max);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findByYear(int min, int max) {

        List<Vehicle> vehicleList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE year BETWEEN ? AND ?;");
            ps.setInt(1, min);
            ps.setInt(2, max);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {

        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findMakeModel(String make, String model) {
        List<Vehicle> vehicleList = new ArrayList<>();
        //creat the vehicle list in here
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE make LIKE ? AND model LIKE ?;");
            ps.setString(1, make);
            ps.setString(2, model);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {

        }
        return vehicleList;
    }

    @Override
    public List<Vehicle> findByVin(int vin) {
        List<Vehicle> vehicleList = new ArrayList<>();
        //creat the vehicle list in here
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM vehicles WHERE vin = ?;");
            ps.setInt(1, vin);
            ps.executeQuery();


            ResultSet resultSet = ps.getResultSet();
            while (resultSet.next()) {
                int vinFromDataBase = resultSet.getInt( "vin");
                int yearFromDataBase = resultSet.getInt("year");
                boolean boolFromDataBase = resultSet.getBoolean("sold");
                String makeFromDataBase = resultSet.getString("make");
                String modelFromDataBase = resultSet.getString("model");
                String vehicleTypeFromDataBase = resultSet.getString("vehicle_type");
                String colorFromDataBase = resultSet.getString("car_color");
                int odometerFromDataBase = resultSet.getInt("odometer");
                double priceFromDataBase = resultSet.getDouble("price");

                vehicleList.add(new Vehicle(vinFromDataBase, yearFromDataBase, makeFromDataBase, modelFromDataBase,
                        vehicleTypeFromDataBase, colorFromDataBase, odometerFromDataBase, priceFromDataBase ));
            }
        }catch (SQLException e) {

        }
        return vehicleList;
    }
}
