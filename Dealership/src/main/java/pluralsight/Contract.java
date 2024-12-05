package pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract public class Contract {
    protected String customerName;
    protected String customerEmail;
    protected String dateOfContract;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String customerName, String customerEmail, Vehicle vehicleSold) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
        //take
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.now();
        dateOfContract = date.format(dateFormatter);
    }


    abstract public double getTotalPrice();
    abstract public double getMonthlyPayment();
}
