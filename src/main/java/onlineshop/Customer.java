package onlineshop;

import onlineshop.enums.Gender;
import onlineshop.order.Order;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// TODO: add JavaDoc like in {@link PlantMee}
public class Customer {
    /**
     * Generates a new customer number for each customer
     */
    private static Integer customerCounter = 1;
    /** Converts the date string into a {@link Date} */
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");

    protected int customerNo;
    protected String firstname;
    protected String surname;
    protected Gender gender;
    protected LocalDate birthDate;
    protected Cart cart;
    protected List<Order> orders = new ArrayList<>();

    public Customer() {
        this.customerNo = customerCounter++;
    }

    public Customer(String firstName, String lastName, Cart cart) {
        this();
        // TODO: copy fields
    }

    public Customer(String firstname, String surname, Gender gender, String birthDate, Cart cart) {
        this(firstname, surname, cart);
        // TODO: copy fields
        this.gender = gender;
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order newOrder) {
        // TODO: add `newOrder` to orders
        // TODO: create a CSV for the order
        orders.add(newOrder);
    }

    public Order getOrderByOrderNumber(Integer orderNo) {
        // TODO: find order by order number and return it
        return null;
    }

    // TODO: generate Getters
}
