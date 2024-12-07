
package pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalesContractDAOmySqlmpl implements SalesContractDAO{
    private DataSource ds;
    public SalesContractDAOmySqlmpl (DataSource ds) {
        this.ds = ds;
    }
    @Override
    public void saveContract(SalesContract contract) {
        List<Contract> contractsList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("""
             INSERT INTO sales_contracts(date, vin, customer_name, customer_email, monthly_payment, total_price, sales_tax, recording_fee, processing_fee, financing )
             VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
             """);
            ps.setString(1, contract.dateOfContract);
            ps.setInt(2, contract.vehicleSold.getVin());
            ps.setString(3, contract.customerName);
            ps.setString(4, contract.customerEmail);
            ps.setDouble(5, contract.monthlyPayment);
            ps.setDouble(6, contract.totalPrice);
            ps.setDouble(7, contract.getSalesTax());
            ps.setDouble(8, contract.getRecordingFee());
            ps.setDouble(9, contract.getProcessingFee());
            ps.setBoolean(10,contract.isFinancing());
            ps.executeUpdate();

        }catch (SQLException e) {
            throw new RuntimeException(e);
        };
    }
}
