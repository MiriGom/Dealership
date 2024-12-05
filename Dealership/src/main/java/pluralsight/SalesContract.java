package pluralsight;

public class SalesContract extends Contract{
    private final double salesTax;
    private final double recordingFee;
    private final double processingFee;
    private boolean financing;



    SalesContract(String customerName, String customerEmail, Vehicle vehicleSold, boolean financing) {
        super(customerName, customerEmail, vehicleSold);
        this.salesTax = 0.05;
        this.recordingFee = 100.00;
        this.processingFee = vehicleSold.getPrice() >= 10000? 495:295;
        this.financing = financing;
        if (vehicleSold.getPrice() >= 10000 && financing) {
            monthlyPayment = vehicleSold.getPrice() * 0.0425;
        } if (vehicleSold.getPrice() < 10000 && financing) {
            monthlyPayment = vehicleSold.getPrice() * 0.0525;
        } else {
            monthlyPayment = 0;
        }
    }

    public double getSalesTax() {
        return salesTax;
    }
    public double getRecordingFee() {
        return recordingFee;
    }
    public double getProcessingFee() {
        return processingFee;
    }
    public boolean isFinancing() {
        return financing;
    }
    public void setFinancing(boolean financing) {
        this.financing = financing;
    }
    @Override
    public double getTotalPrice(){

        totalPrice = (vehicleSold.getPrice() + processingFee + recordingFee) * (1 + salesTax );
        return totalPrice;
    }
    @Override
    public double getMonthlyPayment() {
        return monthlyPayment;
    }

    @Override
    public String toString() {
        return String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f\n",
                dateOfContract, customerName, customerEmail, vehicleSold.getVin(), vehicleSold.getYear(),
                vehicleSold.getMake(), vehicleSold.getModel(), vehicleSold.getVehicleType(), vehicleSold.getColor(),
                vehicleSold.getOdometer(), vehicleSold.getPrice(), salesTax, recordingFee, processingFee, totalPrice, financing? "Yes":"No", monthlyPayment);
    }
    //provide overrides for getTotalPrice and getMonthlyPaymentscv
}
