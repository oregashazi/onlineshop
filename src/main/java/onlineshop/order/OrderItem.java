package onlineshop.order;

import onlineshop.merchandise.CartItem;

/**
 * Represents an item in an order.
 */
public class OrderItem extends CartItem {
    private double discount;
    private double taxAmount;

    public OrderItem() { }

    public OrderItem(CartItem cartItem) {
        super(cartItem);
        this.discount = 0;
        this.taxAmount = 0;
    }

    public OrderItem(CartItem cartItem, double discountPercent, double taxPercent) {
        this(cartItem);
        this.discount = (cartItem.getPrice() * discountPercent) * cartItem.getQuantity();
        this.taxAmount = (cartItem.getPrice() * taxPercent) * cartItem.getQuantity();
    }

    public double getDiscount() {
        return discount;
    }

    public double getTaxAmount() {
        return taxAmount;
    }
}
