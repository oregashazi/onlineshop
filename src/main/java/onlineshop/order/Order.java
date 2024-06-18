package onlineshop.order;

import onlineshop.PlantMee;
import onlineshop.merchandise.CartItem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

/**
 * This class represents an order in the online shop. It contains information about the order items,
 * billing, order date, delivery date, and various financial details such as subtotal, discount, taxes, and grand total.
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */
public class Order {
    private final static double DISCOUNT_PERCENTAGE = 0.05;
    private final static double TAX_PERCENTAGE = 0.07;
    private final static double SHIPPING_COSTS = 3.99;
    private static int orderCounter = 1;

    private int orderNo;
    private List<OrderItem> items = new ArrayList<>();
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private Billing billing;
    private double subTotal = 0.0;
    private double discount = 0.0;
    private double taxes = 0.0;
    private double grandTotal = 0.0;

    /**
     * Default constructor for Order. Increments the order counter and assigns an order number.
     */
    public Order() {
        this.orderNo = orderCounter++;
    }

    /**
     * Constructs an Order with the given billing information and list of cart items.
     *
     * @param billing   {@link Billing}
     * @param cartItems {@link List<CartItem>}
     */
    public Order(Billing billing, List<CartItem> cartItems) {
        this();
        this.billing = billing;
        this.orderDate = LocalDate.now();
        this.deliveryDate = addWorkDays(this.orderDate, 3);
        placeOrder(cartItems);
    }

    /**
     * Processes the list of cart items, converting them to order items, and calculates
     * the subtotal, discount, taxes, and grand total for the order.
     *
     * @param cartItems {@link List<CartItem>}
     */
    private void placeOrder(List<CartItem> cartItems) {
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem(cartItem);
            items.add(orderItem);
            subTotal += cartItem.getPrice() * cartItem.getQuantity();
        }
        discount = subTotal * DISCOUNT_PERCENTAGE;
        discount = floorToTwoDecimalPlaces(discount);
        taxes = subTotal * TAX_PERCENTAGE;
        taxes = floorToTwoDecimalPlaces(taxes);
        grandTotal = subTotal + SHIPPING_COSTS; // + taxes - discount
        grandTotal = floorToTwoDecimalPlaces(grandTotal);
    }

    /**
     * Rounds down the given value to two decimal places.
     *
     * @param value {@link Double}
     * @return rounded value {@link Double}
     */
    private double floorToTwoDecimalPlaces(double value) {
        return Math.floor(value * 100) / 100.0;
    }

    /**
     * Adds a specified number of workdays to a given date.
     *
     * @param date     {@link LocalDate}
     * @param workdays {@link Integer}
     * @return resulting date {@link LocalDate}
     */
    public LocalDate addWorkDays(LocalDate date, int workdays) {
        if (workdays < 1) {
            return date;
        }

        LocalDate result = date;
        int addedDays = 0;
        while (addedDays < workdays) {
            result = result.plusDays(1);
            DayOfWeek dayOfWeek = result.getDayOfWeek();
            if (!(dayOfWeek == SATURDAY || dayOfWeek == SUNDAY)) {
                ++addedDays;
            }
        }
        return result;
    }

    // Getters and Setters with JavaDoc

    /**
     * Gets the order counter.
     *
     * @return orderCounter {@link Integer}
     */
    public static int getOrderCounter() {
        return orderCounter;
    }

    /**
     * Sets the order counter.
     *
     * @param orderCounter {@link Integer}
     */
    public static void setOrderCounter(int orderCounter) {
        Order.orderCounter = orderCounter;
    }

    /**
     * Gets the order number.
     *
     * @return orderNo {@link Integer}
     */
    public int getOrderNo() {
        return orderNo;
    }

    /**
     * Sets the order number.
     *
     * @param orderNo {@link Integer}
     */
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * Gets the list of order items.
     *
     * @return items {@link List<OrderItem>}
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * Sets the list of order items.
     *
     * @param items {@link List<OrderItem>}
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    /**
     * Gets the order date.
     *
     * @return orderDate {@link LocalDate}
     */
    public LocalDate getOrderDate() {
        return orderDate;
    }

    /**
     * Sets the order date.
     *
     * @param orderDate {@link LocalDate}
     */
    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Gets the delivery date.
     *
     * @return deliveryDate {@link LocalDate}
     */
    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    /**
     * Sets the delivery date.
     *
     * @param deliveryDate {@link LocalDate}
     */
    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    /**
     * Gets the billing information.
     *
     * @return billing {@link Billing}
     */
    public Billing getBilling() {
        return billing;
    }

    /**
     * Sets the billing information.
     *
     * @param billing {@link Billing}
     */
    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    /**
     * Gets the subtotal amount for the order.
     *
     * @return subTotal {@link Double}
     */
    public double getSubTotal() {
        return Double.parseDouble(PlantMee.df.format(subTotal));
    }

    /**
     * Sets the subtotal amount for the order.
     *
     * @param subTotal {@link Double}
     */
    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    /**
     * Gets the discount amount for the order.
     *
     * @return discount {@link Double}
     */
    public double getDiscount() {
        return Double.parseDouble(PlantMee.df.format(discount));
    }

    /**
     * Sets the discount amount for the order.
     *
     * @param discount {@link Double}
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * Gets the tax amount for the order.
     *
     * @return taxes {@link Double}
     */
    public double getTaxes() {
        return taxes;
    }

    /**
     * Sets the tax amount for the order.
     *
     * @param taxes {@link Double}
     */
    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    /**
     * Gets the grand total amount for the order.
     *
     * @return grandTotal {@link Double}
     */
    public double getGrandTotal() {
        return Double.parseDouble(PlantMee.df.format(grandTotal));
    }

    /**
     * Sets the grand total amount for the order.
     *
     * @param grandTotal {@link Double}
     */
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }
}