package onlineshop.order;

import onlineshop.PlantMee;
import onlineshop.merchandise.CartItem;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

// TODO: add JavaDoc like in {@link PlantMee}
public class Order {
    private final static double DISCOUNT_PERCENTAGE = 0.05;
    // Mehrwertsteuer für Pflanzen beträgt 7%
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


    public Order() {
        this.orderNo = orderCounter++;
    }

    public Order(Billing billing, List<CartItem> cartItems) {
        this();
        this.billing = billing;
        this.orderDate = LocalDate.now();
        this.deliveryDate = addWorkDays(this.orderDate, 3);
        placeOrder(cartItems);
    }

    private void placeOrder(List<CartItem> cartItems) {
        // TODO: convert all cart items to order items
        // TODO: add all order items to order
        // TODO: add each orderItem's numbers to subTotal, discount, taxes and grandTotal
        for (CartItem cartItem : cartItems) {
            OrderItem orderItem = new OrderItem(cartItem);
            items.add(orderItem);
            subTotal += cartItem.getPrice() * cartItem.getQuantity();
        }
        discount = subTotal * DISCOUNT_PERCENTAGE;
        discount = floorToTwoDecimalPlaces(discount);
        taxes = subTotal * TAX_PERCENTAGE;
        taxes = floorToTwoDecimalPlaces(taxes);
        grandTotal = subTotal  + SHIPPING_COSTS; // + taxes - discount
        grandTotal = floorToTwoDecimalPlaces(grandTotal);

//        discount = Double.parseDouble(PlantMee.df.format(discount));
//        taxes = Double.parseDouble(PlantMee.df.format(taxes));
//        grandTotal = Double.parseDouble(PlantMee.df.format(grandTotal));
    }

    private double floorToTwoDecimalPlaces(double value) {
        return Math.floor(value * 100) / 100.0;
    }

    /**
     * Adds `workdays` days to the selected `date`
     * @param date {@link LocalDate}
     * @param workdays {@link Integer}
     * @return resultingDate {@link LocalDate}
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

    public static int getOrderCounter() {
        return orderCounter;
    }

    public static void setOrderCounter(int orderCounter) {
        Order.orderCounter = orderCounter;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Billing getBilling() {
        return billing;
    }

    public void setBilling(Billing billing) {
        this.billing = billing;
    }

    public double getSubTotal() {
        return Double.parseDouble(PlantMee.df.format(subTotal));
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getDiscount() {
        return Double.parseDouble(PlantMee.df.format(discount));
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTaxes() {
        return taxes;
    }

    public void setTaxes(double taxes) {
        this.taxes = taxes;
    }

    public double getGrandTotal() {
        return Double.parseDouble(PlantMee.df.format(grandTotal));
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    // TODO: generate all Getters
    // TODO: for number Getters, use `PlantMee.df.format()` to limit them to 2 decimal digits
}
