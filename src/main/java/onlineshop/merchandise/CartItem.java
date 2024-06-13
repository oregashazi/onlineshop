package onlineshop.merchandise;

import onlineshop.PlantMee;

// TODO: add JavaDoc like in {@link PlantMee}
public class CartItem extends Plant {
    protected int quantity = 0;

    public CartItem() {
    }

    public CartItem(Plant plant) {
        this.articleNo = plant.articleNo;
        this.category = plant.category;
        this.seed = plant.seed;
        this.name = plant.name;
        this.price = plant.price;
        this.image = plant.image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getShowQuantity() {
        return quantity > 1;
    }

    public void increaseQuantity() {
        quantity++;
    }

    public void decreaseQuantity() {
        quantity--;
    }

    public double getSubtotal() {
        return quantity * price;
    }

    public String getTotalPriceFormatted() {
        return PlantMee.df.format(getSubtotal());
    }
}
