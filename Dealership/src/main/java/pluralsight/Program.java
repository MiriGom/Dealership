package pluralsight;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/cardealershipdb";
        String user = args[0];
        String password = args[1];

        BasicDataSource bds = new BasicDataSource();
        bds.setUrl(url);
        bds.setUsername(user);
        bds.setPassword(password);
        MiriamCompany mc = new MiriamCompany(bds);

        UserInterface uInterface = new UserInterface(mc.getDealershipFromDataBase(), bds);

       boolean isRunning = true;
       while (isRunning) {
           uInterface.userInterface();
           isRunning = false;
       }
    }

}
