package pluralsight;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private List<Dealership> dealershipList;
    private SalesContractDAOmySqlmpl salesContractDao;
    private VehicleDAO vehicleDAO;
    Scanner scan = new Scanner(System.in);
    private Dealership dealership; //class variable to hold the list of Vehicles

    public UserInterface(List<Dealership> dealershipList, DataSource ds) {
        this.dealershipList = dealershipList;
        this.vehicleDAO = new VehicleDAOSqlImp(ds);
        this.salesContractDao = new SalesContractDAOmySqlmpl(ds);
    }
    public void userInterface(){

        displayDealerships();




    }
    public void display(){

        boolean isRunning = true;
        while (isRunning) {
            System.out.print("""
                    ========================================
                    
                                   DEALERSHIP
                    
                    ========================================
                    1) SEARCH BY PRICE
                    2) SEARCH BY MAKE/MODEL
                    3) SEARCH BY YEAR
                    4) SEARCH BY COLOR
                    5) SEARCH BY MILEAGE
                    6) SEARCH VEHICLE TYPE
                    7) SEARCH WHOLE INVENTORY
                    8) ADD VEHICLE
                    9) REMOVE VEHICLE
                    10) SELL/LEASE A VEHICLE
                    11) SEARCH BY DEALERSHIP
                    99) Exit
                    """);
            //added try catch so that it tells you when you entered an invalid input.
            try {
                int userCommand = scan.nextInt();
                scan.nextLine();
                switch (userCommand) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequests();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processGetAllVehicleRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 10:
                        getContractInfo();
                        break;
                    case 99:
                        System.out.println("Bye Bye now");
                        isRunning =false;
                }
            }catch (InputMismatchException e) {
                System.out.println("Invalid input, please enter a number.");
                scan.nextLine();
            }
        }
    }

    public void processGetByPriceRequest() {

        System.out.println("Please enter the min price you are looking for");
        double userMinPrice = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter your max price you are looking for");
        double userMaxPrice = scan.nextInt();
        scan.nextLine();
        

        for (Vehicle v : vehicleDAO.findByPrice(userMinPrice, userMaxPrice)) {
            System.out.println(v);
        }
    }
    public void processGetByMakeModelRequest(){
        System.out.println("Please enter the Make you are searching for");
        String userMake = scan.nextLine();
        System.out.println("Please enter Model");
        String userModel = scan.nextLine();

        for (Vehicle v : vehicleDAO.findMakeModel(userMake, userModel)) {
            System.out.println(v);
        }
    }
    public void processGetByYearRequest(){
        System.out.println("Please enter the min year your are searching for");
        int userMinYear = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter the max year");
        int userMaxYear = scan.nextInt();
        scan.nextLine();

            for (Vehicle v : vehicleDAO.findByYear(userMinYear, userMaxYear)){
            System.out.println(v);
        }

    }
    public void processGetByColorRequest(){
        System.out.println("Please enter the color you are searching for?");
        String userColor = scan.nextLine();

            for (Vehicle v : vehicleDAO.findByColor(userColor)) {
                System.out.println(v);
            }
    }
    public void processGetByMileageRequests(){
        System.out.println("Please enter a min mileage");
        int minMileage = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter the max mileage");
        int maxMileage  = scan.nextInt();
        scan.nextLine();
        for (Vehicle v : vehicleDAO.findByMileage(minMileage, maxMileage)){
            System.out.println(v);
        }
    }
    public void processGetByVehicleTypeRequest(){
        System.out.println("Please enter the type of vehicle you are looking for");
        String vehicleType = scan.nextLine();
        for (Vehicle v : vehicleDAO.findByVehicleType(vehicleType)) {
            System.out.println(v);
        }
    }
    public void processGetAllVehicleRequest(){

            for (Vehicle vehicle : vehicleDAO.findAllVehicles()) {
                System.out.println(vehicle);
            }
    }
    public void processAddVehicleRequest(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        System.out.println("Please enter vin of vehicle");
        int userVehicleVin = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter year of vehicle");
        int userVehicleYear = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter make of vehicle");
        String userVehicleMake = scan.nextLine();
        System.out.println("Please enter model of vehicle");
        String userVehicleModel = scan.nextLine();
        System.out.println("Please enter color of vehicle");
        String userVehicleColor = scan.nextLine();
        System.out.println("Please enter type of vehicle");
        String userVehicleType = scan.nextLine();
        System.out.println("Please enter mileage of vehicle");
        int userVehicleOdometer = scan.nextInt();
        scan.nextLine();
        System.out.println("Please enter price of vehicle");
        double userVehiclePrice = scan.nextDouble();
        scan.nextLine();

        Vehicle userVehicle = new Vehicle(userVehicleVin, userVehicleYear, userVehicleMake, userVehicleModel, userVehicleType, userVehicleColor, userVehicleOdometer, userVehiclePrice);
        dealership.addVehicle(userVehicle);
        dealershipFileManager.saveDealership(dealership);

    }
    public void processRemoveVehicleRequest(){
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        System.out.println("Enter vin of vehicle you want to remove");
        int userVin = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < dealership.getAllVehicles().size(); i++) {
            if (userVin == dealership.getAllVehicles().get(i).getVin()) {
                System.out.println("Are you sure you want to remove " + dealership.getAllVehicles().get(i) + "?");
                String userAnswer = scan.nextLine();

                if (userAnswer.equalsIgnoreCase("yes")) {
                   dealership.removeVehicle(dealership.getAllVehicles().get(i));
                   System.out.println("Vehicle successfully removed :)");
                   dealershipFileManager.saveDealership(dealership);


                }
            }
        }
    }
    //TODO instantiate contractDataManager
    public  void getContractInfo() {
       // ContractFileManager contractFileManager = new ContractFileManager();
        System.out.println("Enter name of the customer ");
        String custName = scan.nextLine();
        System.out.println("Enter the email address of the customer");
        String custEmail = scan.nextLine();
        System.out.println("Please enter the vin of car to purchase or lease");
        int userCarVin = scan.nextInt();
        Vehicle vehicleSold = vehicleDAO.findByVin(userCarVin).get(0);
       // while (vehicleSold != null){
           // scan.nextInt();
      //  }
        scan.nextLine();
        System.out.println("Does the customer want to buy or lease?");
        String custInput = scan.nextLine();
        Contract contract = null;

        if (custInput.equalsIgnoreCase("buy")) {
                boolean custFinance = getSalesContract();
                        contract = new SalesContract(custName, custEmail, vehicleSold, custFinance);
                        salesContractDao.saveContract((SalesContract) contract);
            } if (custInput.equalsIgnoreCase("lease")){
                contract = new LeaseContract(custName, custEmail, vehicleSold );
            }
       // new ContractDAOcsvImpl().saveContract(contract);

    }

    public boolean getSalesContract() //extends Contract
    {
        System.out.println("Does the customer want to finance?");
        String userInput = scan.nextLine();
        if (userInput.equalsIgnoreCase("yes")) {
            return true;
        }
        return false;
    }
    public void displayDealerships() {

       for (int i = 0; i < dealershipList.size(); i++) {
           Dealership dealership = dealershipList.get(i);
           System.out.printf( (i + 1) + ") Dealership: %s address: %s\n", dealership.getName(), dealership.getAddress());

       }
        System.out.println("Select your Dealership");
        String userChoice = scan.nextLine();
        System.out.println("You chose Tampa");
        display();
    }



}
