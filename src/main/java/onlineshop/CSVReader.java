package onlineshop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import onlineshop.merchandise.Plant;

// TODO: add JavaDoc like in {@link PlantMee}
public class CSVReader {
    public static List<Plant> readPlantsFromCSV(String filePath) {
        List<Plant> plants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
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
