package pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeaseContractDAOmySqlImp implements LeaseContractDAO{
    private DataSource ds;
    public LeaseContractDAOmySqlImp (DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void saveLeaseContract(LeaseContract contract) {
        List<Contract> leaseContractList = new ArrayList<>();
        try(Connection connection = ds.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("""
             INSERT INTO lease_contracts(date, vin, customer_name, customer_email, monthly_payment, total_price, expected_ending_value, lease_fee, monthly_lease_finance)
             VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);
             """);
            ps.setString(1, contract.dateOfContract);
            ps.setInt(2, contract.vehicleSold.getVin());
            ps.setString(3, contract.customerName);
            ps.setString(4, contract.customerEmail);
            ps.setDouble(5, contract.monthlyPayment);
            ps.setDouble(6, contract.totalPrice);
            ps.setDouble(7, contract.getExpectedEndingValue());
            ps.setDouble(8, contract.getLeaseFee());
            ps.setDouble(9, contract.getMonthlyLeaseFinance());
            ps.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
