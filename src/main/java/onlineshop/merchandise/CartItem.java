package onlineshop.merchandise;

import onlineshop.PlantMee;

/**
 * This class represents an item in the shopping cart.
 * It extends the {@link Plant} class and adds functionality for quantity and subtotal calculations.
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */
public class CartItem extends Plant {
    protected int quantity = 0;

    /**
     * Default constructor for CartItem.
     */
    public CartItem() {
    }

    /**
     * Constructs a CartItem using a Plant object.
     *
     * @param plant the Plant object to base this CartItem on.
     */
    public CartItem(Plant plant) {
        this.articleNo = plant.articleNo;
        this.category = plant.category;
        this.seed = plant.seed;
        this.name = plant.name;
        this.price = plant.price;
        this.image = plant.image;
    }


    /**
     * Gets the quantity of the CartItem.
     *
     * @return the quantity of the CartItem.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the CartItem.
     *
     * @param quantity the new quantity to be set.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Checks if the quantity is more than 1.
     *
     * @return true if quantity is more than 1, false otherwise.
     */
    public boolean getShowQuantity() {
        return quantity > 1;
    }

    /**
     * Increases the quantity of the CartItem by 1.
     */
    public void increaseQuantity() {
        quantity++;
    }

    /**
     * Decreases the quantity of the CartItem by 1.
     */
    public void decreaseQuantity() {
        quantity--;
    }

    /**
     * Calculates the subtotal for the CartItem.
     *
     * @return the subtotal for the CartItem.
     */
    public double getSubtotal() {
        return quantity * price;
    }

    /**
     * Gets the total price of the CartItem formatted as a string with two decimal places.
     *
     * @return the total price of the CartItem formatted as a string.
     */
    public String getTotalPriceFormatted() {
        return PlantMee.df.format(getSubtotal());
    }
}
