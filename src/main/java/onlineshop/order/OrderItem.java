package onlineshop.order;

import onlineshop.merchandise.CartItem;

// TODO: add JavaDoc like in {@link PlantMee}
public class OrderItem extends CartItem {
    private double discount;
    private double taxAmount;

    public OrderItem() { }

    public OrderItem(CartItem cartItem) {
        // TODO: copy the fields
    }

    public OrderItem(CartItem cartItem, double discountPercent, double taxPercent) {
        this(cartItem);
        // TODO: calculate discount and taxAmount
    }
    // TODO: generate Getters
}
