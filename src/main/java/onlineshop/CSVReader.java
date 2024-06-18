package onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import onlineshop.merchandise.Plant;

/**
 * This class reads plant data from a CSV file and creates Plant objects.
 * It provides a method to read plants from a CSV file and return them as a List.
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */
public class CSVReader {

    /**
     * Reads plant data from a CSV file and returns a list of Plant objects.
     *
     * @param filePath The path to the CSV file containing plant data.
     * @return A List of Plant objects read from the CSV file.
     */
    public static List<Plant> readPlantsFromCSV(String filePath) {
        List<Plant> plants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Plant plant = new Plant(data);

                plants.add(plant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return plants;
    }
}
