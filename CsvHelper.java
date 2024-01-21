import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {
    private String csvFilePath;

    public CsvHelper(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    public void writeData(List<String[]> data) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFilePath, true))) {
            for (String[] row : data) {
                writer.println(String.join(",", row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> readData() {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                records.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
