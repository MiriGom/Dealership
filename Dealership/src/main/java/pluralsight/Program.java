package pluralsight;

import java.util.Scanner;

public class Program {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        UserInterface uInterface = new UserInterface();
        System.out.println("Press Enter");
       scan.nextLine();

       boolean isRunning = true;
       while (isRunning) {
           uInterface.userInterface();
           isRunning = false;
       }
    }

}
