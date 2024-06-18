package onlineshop.merchandise;

import onlineshop.enums.Category;

/**
 * Represents a plant article in the online shop. This class extends the Article class and adds
 * specific properties related to plants such as category, seed status, and name.
 *
 * @see onlineshop.PlantMee
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */
public class Plant extends Article {
    protected Category category;
    protected boolean seed;
    protected String name;

    /**
     * Default constructor for creating a Plant object with no initial values.
     */
    public Plant() {
        super();
    }

    /**
     * Constructs a Plant object with the specified name and category.
     *
     * @param name the name of the plant
     * @param category the category of the plant as a string
     */
    public Plant(String name, String category) {
        super();
        this.name = name;
        this.category = Category.fromString(category);
    }

    /**
     * Constructs a Plant object using an array of strings containing plant data.
     *
     * @param data an array of strings containing the plant data
     */
    public Plant(String[] data) {
        this.articleNo = (Integer.parseInt(data[0]));
        this.category = Category.fromString(data[1]);
        this.seed = (Boolean.parseBoolean(data[2]));
        this.name = data[3];
        this.price = Double.parseDouble(data[4]);
        this.image = data[5];
    }

    /**
     * Gets the category of the plant.
     *
     * @return the category of the plant as a {@link Category} object
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Gets the seed status of the plant.
     *
     * @return the seed status of the plant as a {@link Boolean}
     */
    public Boolean getSeed() {
        return seed;
    }

    /**
     * Gets the name of the plant.
     *
     * @return the name of the plant as a {@link String}
     */
    public String getName() {
        return name;
    }
}
