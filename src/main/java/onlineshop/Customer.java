package onlineshop;

import onlineshop.enums.Gender;
import onlineshop.order.Order;
import onlineshop.order.OrderItem;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a customer of the online shop.
 *
 * This class manages customer information such as name, gender, birth date, shopping cart,
 * and orders placed. It provides methods to add orders, retrieve orders by order number,
 * and generate CSV files for each order placed.
 *
 * @author Daniil Mykhailovskyi
 * @version 1.0
 */
public class Customer {
    /**
     * Generates a new customer number for each customer
     */
    private static Integer customerCounter = 1;

    /** Converts the date string into a {@link LocalDate} */
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");

    protected int customerNo;
    protected String firstname;
    protected String surname;
    protected Gender gender;
    protected LocalDate birthDate;
    protected Cart cart;
    protected List<Order> orders = new ArrayList<>();

    /**
     * Default constructor to initialize a customer object with a unique customer number.
     */
    public Customer() {
        this.customerNo = customerCounter++;
    }

    /**
     * Constructor to initialize a customer object with first name, last name, and a shopping cart.
     *
     * @param firstName The first name of the customer
     * @param lastName The last name of the customer
     * @param cart The shopping cart associated with the customer
     */
    public Customer(String firstName, String lastName, Cart cart) {
        this();
        // TODO: copy fields
        this.firstname = firstName;
        this.surname = lastName;
        this.cart = cart;
    }

    /**
     * Constructor to initialize a customer object with full details including gender, birth date, and a shopping cart.
     *
     * @param firstname The first name of the customer
     * @param surname The last name of the customer
     * @param gender The gender of the customer (Male/Female/Other)
     * @param birthDate The birth date of the customer in "dd.mm.yyyy" format
     * @param cart The shopping cart associated with the customer
     */
    public Customer(String firstname, String surname, Gender gender, String birthDate, Cart cart) {
        this(firstname, surname, cart);
        // TODO: copy fields
        this.gender = gender;
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    /**
     * Retrieves the list of orders placed by this customer.
     *
     * @return The list of orders placed by the customer
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Adds a new order to the customer's order history.
     * Also creates a CSV file for the order.
     *
     * @param newOrder The new order to be added
     */
    public void addOrder(Order newOrder) {
        // TODO: add `newOrder` to orders
        // TODO: create a CSV for the order
        orders.add(newOrder);

        createCSVForOrder(newOrder);
    }

    /**
     * Retrieves an order by its order number.
     *
     * @param orderNo The order number to search for
     * @return The order with the specified order number, or null if not found
     */
    public Order getOrderByOrderNumber(Integer orderNo) {
        // TODO: find order by order number and return it
        for (Order order : orders) {
            if (order.getOrderNo() == orderNo) {
                return order;
            }
        }
        return null;
    }

    /**
     * Private method to create a CSV file for a specific order.
     *
     * @param order The order for which the CSV file is to be created
     */
    private void createCSVForOrder(Order order) {
        String fileName = "order_" + order.getOrderNo() + ".csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            // Write header
            writer.write("Order Number,Order Date,Delivery Date,Item,Quantity,Price,Subtotal,Discount,Taxes,Grand Total\n");

            // Write order details
            writer.write(order.getOrderNo() + ",");
            writer.write(order.getOrderDate() + ",");
            writer.write(order.getDeliveryDate() + ",");

            List<OrderItem> items = order.getItems();
            for (OrderItem item : items) {
                writer.write(item.getArticleNo() + ",");
                writer.write(item.getQuantity() + ",");
                writer.write(PlantMee.df.format(item.getPrice()) + ",");
                writer.write(PlantMee.df.format(item.getSubtotal()) + "\n");
            }

            writer.write(",,," + order.getSubTotal() + ",");
            writer.write(order.getDiscount() + ",");
            writer.write(PlantMee.df.format(order.getTaxes()) + ",");
            writer.write(order.getGrandTotal() + "\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // TODO: Generate getters and setters for all fields

    public static Integer getCustomerCounter() {
        return customerCounter;
    }

    public static void setCustomerCounter(Integer customerCounter) {
        Customer.customerCounter = customerCounter;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        Customer.formatter = formatter;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
