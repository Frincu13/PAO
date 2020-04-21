package ro.unibuc.fmi;
import java.sql.Timestamp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Audit {
    private static Audit single_instance = null;

    // private constructor restricted to this class itself
    private Audit()
    {
        System.out.println("S-a creeat Audit-ul");

    }



    public static Audit getInstance()
    {
        if (single_instance == null)
            single_instance = new Audit();

        return single_instance;
    }


    public void writePersonsToFile(String t) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("audit.csv",true))) {
            bufferedWriter.write(t+ "," + timestamp);
            bufferedWriter.newLine();

        } catch (IOException e) {
            System.out.println("Could not write data to file");
            return;
        }
        System.out.println("Successfully wrote "+ timestamp);
    }
}
