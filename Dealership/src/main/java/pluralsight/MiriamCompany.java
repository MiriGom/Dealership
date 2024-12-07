package pluralsight;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MiriamCompany {

    static List<Dealership> dealershipList = new ArrayList<>();

    private DataSource dataSource;
    public MiriamCompany(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    public List<Dealership> getDealershipFromDataBase(){
        try (Connection connection = dataSource.getConnection()) {

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM cardealershipdb.dealerships;");
            ps.executeQuery();

            ResultSet resultSet = ps.getResultSet();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");


                dealershipList.add(new Dealership(name, address, phone));
            }return dealershipList;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
