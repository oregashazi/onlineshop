package onlineshop.merchandise;

import onlineshop.enums.Category;

// TODO: add JavaDoc like in {@link PlantMee}
public class Plant extends Article {
    protected Category category;
    protected boolean seed;
    protected String name;

    public Plant() {
        super();
    }

    public Plant(String name, String category) {
        super();
        this.name = name;
        this.category = Category.fromString(category);
    }

    public Plant(String[] data){
        this.articleNo = (Integer.parseInt(data[0]));
        this.category = Category.fromString(data[1]);
        this.seed = (Boolean.parseBoolean(data[2]));
        this.name = data[3];
        this.price = Double.parseDouble(data[4]);
        this.image = data[5];
    }

    public Category getCategory() {
        return category;
    }

    public Boolean getSeed() {
        return seed;
    }

    public String getName() {
        return name;
    }
}
