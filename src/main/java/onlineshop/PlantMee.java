package onlineshop;

import onlineshop.enums.PaymentMethod;
import onlineshop.merchandise.Plant;
import onlineshop.order.Billing;
import onlineshop.order.Order;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * This class represents a plant shop. It reads its assortment from a CSV file, allows to sort it by various categories.
 * You may fill a shopping cart, check it out and place several orders.
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */
public class PlantMee {
    /** This allows to trim numbers to 2 decimal digits. */
    public static final DecimalFormat df = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US));
    public static List<Plant> plants = new ArrayList<>();

    public static List<Plant> getArticles() {
        if (plants.size() == 0) {
            plants = CSVReader.readPlantsFromCSV("src/main/resources/static/data/plants.csv");
        }
        return plants;
    }

    public static int getNumOfArticles() {
        return plants.size();
    }

    /**
     * Gets an article/book by its article number
     *
     * @param articleNo {@link Integer}
     * @return existingPlant {@link Plant}
     */
    public static Plant getArticleByNumber(int articleNo) {
        if (plants.size() == 0) {
            plants = CSVReader.readPlantsFromCSV("src/main/resources/static/data/plants.csv");
        }
        for (Plant plant : plants) {
            if (plant.getArticleNo() == articleNo)
                return plant;
        }
        return null;
    }
}
