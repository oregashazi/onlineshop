package test;

import onlineshop.Cart;
import onlineshop.PlantMee;
import onlineshop.enums.PaymentMethod;
import onlineshop.order.Billing;
import onlineshop.order.Order;
import onlineshop.order.OrderItem;

import java.time.LocalDate;
import java.util.List;

/**
 * Tests for {@link onlineshop.order.Order}
 * 1. Generate necessary Getters
 * 2. Implement TODOs
 * 3. Un-comment tests
 * 4. Run tests
 *
 * @author Alfred Walther
 * @version 1.0
 */
public class OrderTest extends TestBase {
    public static void main(String[] args) {
        Order order = createOrder();
        testOrderConstructor(order);
        testPlaceOrder(order);
        System.out.println("[OrderTests] passed");
    }

    /**
     * Creates an order with 10 articles
     * @return the created order
     */
    public static Order createOrder() {
        Billing billing = new Billing("Max", "Mustermann", PaymentMethod.CREDITCARD);
        Cart cart = fillCart();
        return new Order(billing, cart.getItems());
    }

    /**
     * Fills the cart with 10 articles
     * @return the filled cart
     */
    private static Cart fillCart() {
        Cart cart = new Cart();
        for (int i = 1; i <= 10; i++) {
            cart.addArticle(PlantMee.getArticleByNumber(i));
        }
        return cart;
    }

    /**
     * Tests the order constructor
     * @param order the created order
     */
    private static void testOrderConstructor(Order order) {
        Billing billing = order.getBilling();

        assertEquals("Max", billing.getFirstName());
        assertEquals("Mustermann", billing.getLastName());
        assertEquals(PaymentMethod.CREDITCARD, billing.getPaymentMethod());

        LocalDate orderDate = LocalDate.now();
        assertEquals(true, orderDate.isEqual(order.getOrderDate()));

        LocalDate deliveryDate = order.addWorkDays(orderDate, 3);
        assertEquals(true, deliveryDate.isEqual(order.getDeliveryDate()));
        System.out.println("[testOrderConstructor] passed");
    }

    /**
     * Tests the placeOrder method
     * @param order the created order
     */
    private static void testPlaceOrder(Order order) {
        List<OrderItem> items = order.getItems();
        assertEquals(10, items.size());

        String[] plants = {
                "Husarenknöpfchen", "Portulakröschen", "Stehende Geranie",
                "Köcherblümchen", "Hängebegonie", "Knollenbegonie",
                "Strohblume", "Sonnenblume", "Dahlie", "Goldmarie"
        };
        for (int i = 0; i < plants.length; i++) {
            String plant = plants[i];
            assertEquals(plant, items.get(i).getName());
        }

        assertEquals(41.10, order.getSubTotal());
        assertEquals(2.05, order.getDiscount());
        assertEquals(2.87, order.getTaxes());
        assertEquals(45.09, order.getGrandTotal());
        System.out.println("[testPlaceOrder] passed");
    }
}
