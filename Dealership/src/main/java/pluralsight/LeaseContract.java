package pluralsight;

public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;
    private double monthlyLeaseFinance;

    public LeaseContract(String customerName, String customerEmail, Vehicle vehicleSold) {
        super(customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * .5;
        this.leaseFee = vehicleSold.getPrice() * .07;
        this.monthlyLeaseFinance = (expectedEndingValue / 36) * 1.04;
    }
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }
    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }
    public double getLeaseFee() {
        return leaseFee;
    }
    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
    public double getMonthlyLeaseFinance() {
        return monthlyLeaseFinance;
    }
    public void setMonthlyLeaseFinance(double monthlyLeaseFinance) {
        this.monthlyLeaseFinance = monthlyLeaseFinance;
    }
    @Override
    public double getTotalPrice() {
        return totalPrice = (expectedEndingValue + leaseFee);
    }
    @Override
    public double getMonthlyPayment() {
       return monthlyLeaseFinance;
    }

    @Override
    public String toString() {
        return String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f\n", dateOfContract, customerName,
                customerEmail, vehicleSold.getVin(), vehicleSold.getYear(), vehicleSold.getMake(), vehicleSold.getModel(),
                vehicleSold.getVehicleType(), vehicleSold.getColor(), vehicleSold.getOdometer(), vehicleSold.getPrice(),
                expectedEndingValue, leaseFee, totalPrice, monthlyLeaseFinance );
    }
    //provide overrides for getTotalPrice and getMonthlyPayments
}

