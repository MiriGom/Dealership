package pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ContractDAOcsvImpl implements ContractDAO {
    static String contractFilePath = "contracts.csv";
    List<Contract> contractList = new ArrayList<>();

    @Override
    public void saveContract(Contract contract) {
        try {
            FileWriter writer = new FileWriter(contractFilePath, true);
            BufferedWriter bufWriter = new BufferedWriter(writer);

            contractList.add(contract);

            bufWriter.write(contract.toString());

            bufWriter.close();
        } catch (IOException e) {
            System.out.println("Problem writing to file");
        }

    }

}
