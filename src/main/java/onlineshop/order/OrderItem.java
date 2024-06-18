package onlineshop.order;

import onlineshop.merchandise.CartItem;

/**
 * Represents an item in an order, extending from {@link CartItem}.
 * It includes information about any applicable discount and tax amount.
 */
public class OrderItem extends CartItem {
    private double discount; // The discount amount applied to this order item.
    private double taxAmount; // The tax amount applicable to this order item.

    /**
     * Default constructor initializes discount and tax amount to 0.
     */
    public OrderItem() {
        this.discount = 0;
        this.taxAmount = 0;
    }

    /**
     * Constructs an OrderItem object based on an existing CartItem.
     *
     * @param cartItem The CartItem to base this OrderItem on.
     */
    public OrderItem(CartItem cartItem) {
        super(cartItem);
        this.discount = 0;
        this.taxAmount = 0;
    }

    /**
     * Constructs an OrderItem object based on a CartItem, applying a discount and tax percentage.
     *
     * @param cartItem         The CartItem to base this OrderItem on.
     * @param discountPercent  The discount percentage to apply.
     * @param taxPercent       The tax percentage to apply.
     */
    public OrderItem(CartItem cartItem, double discountPercent, double taxPercent) {
        this(cartItem);
        this.discount = (cartItem.getPrice() * discountPercent) * cartItem.getQuantity();
        this.taxAmount = (cartItem.getPrice() * taxPercent) * cartItem.getQuantity();
    }

    /**
     * Retrieves the discount amount for this OrderItem.
     *
     * @return The discount amount as a double.
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * Retrieves the tax amount for this OrderItem.
     *
     * @return The tax amount as a double.
     */
    public double getTaxAmount() {
        return taxAmount;
    }
}
