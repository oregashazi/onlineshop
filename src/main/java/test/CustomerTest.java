package test;

import onlineshop.Cart;
import onlineshop.Customer;
import onlineshop.enums.PaymentMethod;
import onlineshop.order.Billing;
import onlineshop.order.Order;

import java.util.List;

/**
 * Tests for {@link onlineshop.Customer}
 * 1. Generate necessary Getters
 * 2. Implement TODOs
 * 3. Un-comment tests
 * 4. Run tests
 *
 * @author Alfred Walther
 * @version 1.0
 */
public class CustomerTest extends TestBase {
    public static void main(String[] args) {
        Customer customer = new Customer("Max", "Mustermann", new Cart());
        testAddOrder(customer);
        testGetOrderByOrderNumber(customer);
        testGetOrders(customer);
        System.out.println("[CustomerTests] passed");
    }

    /**
     * Tests the addOrder method
     * @param customer the created customer
     */
    private static void testAddOrder(Customer customer) {
        Order newOrder = OrderTest.createOrder();
        customer.addOrder(newOrder);
        assertEquals(1, customer.getOrders().size());

        customer.addOrder(newOrder);
        customer.addOrder(newOrder);
        assertEquals(3, customer.getOrders().size());
        System.out.println("[testAddOrder] passed");
    }

    /**
     * Tests the getOrderByOrderNumber method
     * @param customer the created customer
     */
    private static void testGetOrderByOrderNumber(Customer customer) {
        Order order = customer.getOrderByOrderNumber(1);
        Billing billing = order.getBilling();

        assertEquals("Max", billing.getFirstName());
        assertEquals("Mustermann", billing.getLastName());
        assertEquals(PaymentMethod.CREDITCARD, billing.getPaymentMethod());

        assertEquals(10, order.getItems().size());

        assertEquals(41.10, order.getSubTotal());
        assertEquals(2.05, order.getDiscount());
        assertEquals(2.87, order.getTaxes());
        assertEquals(45.09, order.getGrandTotal());
        System.out.println("[testGetOrderByOrderNumber] passed");
    }

    /**
     * Tests the getOrders method
     * @param customer the created customer
     */
    private static void testGetOrders(Customer customer) {
        List<Order> orders = customer.getOrders();
        assertEquals(3, orders.size());
        System.out.println("[testGetOrders] passed");
    }
}
