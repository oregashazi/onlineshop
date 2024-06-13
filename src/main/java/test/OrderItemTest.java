package test;

import onlineshop.PlantMee;
import onlineshop.enums.Category;
import onlineshop.merchandise.CartItem;
import onlineshop.merchandise.Plant;
import onlineshop.order.OrderItem;

/**
 * Tests for {@link onlineshop.order.OrderItem}
 * 1. Generate necessary Getters
 * 2. Implement TODOs
 * 3. Un-comment tests
 * 4. Run tests
 *
 * @author Alfred Walther
 * @version 1.0
 */
public class OrderItemTest extends TestBase {
    static double discountPercent = 0.05;
    static double taxPercent = 0.19;
    static CartItem cartItem;
    static OrderItem orderItem;

    public static void main(String[] args) {
        Plant plant = PlantMee.getArticleByNumber(10);
        cartItem = new CartItem(plant);
        orderItem = new OrderItem(cartItem);

        testOrderItem10();
        testDiscountAndTax();
        testOrderItem187();
        testDiscountAndTax2();
        System.out.println("[OrderItemTests] passed");
    }

    /**
     * Tests the OrderItem constructor with article 10
     */
    private static void testOrderItem10() {
        assertEquals(10, orderItem.getArticleNo());
        assertEquals(Category.BLUMEN, orderItem.getCategory());
        assertEquals(true, orderItem.getSeed());
        assertEquals("Goldmarie", orderItem.getName());
        assertEquals(3.29, orderItem.getPrice());
        assertEquals(cartItem.getImage(), orderItem.getImage());
        System.out.println("[testOrderItem10] passed");
    }

    /**
     * Tests the getDiscount and getTaxAmount methods
     */
    private static void testDiscountAndTax() {
/*
        cartItem.increaseQuantity();
        orderItem = new OrderItem(cartItem, discountPercent, taxPercent);

        assertEquals(0.1645, orderItem.getDiscount());
        assertEquals(0.6251, orderItem.getTaxAmount());
        System.out.println("[testDiscountAndTax] passed");
*/
    }

    /**
     * Tests the OrderItem constructor with article 187
     */
    private static void testOrderItem187() {
        Plant plant = PlantMee.getArticleByNumber(187);
        cartItem = new CartItem(plant);
        orderItem = new OrderItem(cartItem);

        assertEquals(187, orderItem.getArticleNo());
        assertEquals(Category.BALKONPFLANZEN, orderItem.getCategory());
        assertEquals(false, orderItem.getSeed());
        assertEquals("Enzianstrauch", orderItem.getName());
        assertEquals(14.99, orderItem.getPrice());
        assertEquals(cartItem.getImage(), orderItem.getImage());
        System.out.println("[testOrderItem187] passed");
    }

    /**
     * Tests the getDiscount and getTaxAmount methods
     */
    private static void testDiscountAndTax2() {
/*
        cartItem.increaseQuantity();
        cartItem.increaseQuantity();
        cartItem.increaseQuantity();
        orderItem = new OrderItem(cartItem, discountPercent, taxPercent);

        assertEquals(2.2485, orderItem.getDiscount());
        assertEquals(8.5443, orderItem.getTaxAmount());
        System.out.println("[testDiscountAndTax2] passed");
*/
    }


}
