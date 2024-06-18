package onlineshop;

import onlineshop.merchandise.CartItem;
import onlineshop.merchandise.Plant;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart in an online shop.
 * Allows adding, removing, and modifying quantities of items.
 */
public class Cart {
    final static int MAX_QUANTITY = 15;
    private List<CartItem> items = new ArrayList<>();

    /**
     * Retrieves the list of items in the cart.
     * @return items {@link List} of {@link CartItem}
     */
    public List<CartItem> getItems() {
        return items;
    }

    /**
     * Counts the total number of items in the cart.
     * @return numberOfItems {@link Integer}
     */
    public int getNumOfItems() {
        int numOfItems = 0;
        for (CartItem item : items) {
            numOfItems += item.getQuantity();
        }
        return numOfItems;
    }

    /**
     * Calculates the subtotal of all items in the cart.
     * @return formattedSubtotal {@link String}
     */
    public String getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return PlantMee.df.format(total);
    }

    /**
     * Adds a plant to the cart with a default quantity of 1.
     * If the plant already exists in the cart, increases its quantity (up to {@link Cart#MAX_QUANTITY}).
     * @param plant {@link Plant} to add to the cart
     */
    public void addArticle(Plant plant) {
        CartItem item = findItem(plant.getArticleNo());
        if (item == null) {
            item = new CartItem(plant);
            items.add(item);
        }
        // limit quantity
        if (item.getQuantity() < MAX_QUANTITY) {
            item.increaseQuantity();
        }
    }

    /**
     * Increases the quantity of a specific article in the cart.
     * @param articleNo {@link Integer} article number to increase quantity
     * @return true if quantity was increased successfully, false otherwise
     */
    public boolean increaseQuantity(int articleNo) {
        CartItem existingItem = findItem(articleNo);
        if (existingItem != null) {
            existingItem.increaseQuantity();
            return true;
        }
        return false;
    }

    /**
     * Decreases the quantity of a specific article in the cart.
     * If quantity drops below 1, removes the article from the cart.
     * @param articleNo {@link Integer} article number to decrease quantity
     * @return true if article was successfully decreased in quantity (or removed), false otherwise
     */
    public boolean decreaseQuantity(int articleNo) {
        CartItem existingItem = findItem(articleNo);
        if (existingItem != null) {
            existingItem.decreaseQuantity();
            if (existingItem.getQuantity() < 1) {
                items.remove(existingItem);
                return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Removes a specific article from the cart.
     * @param articleNo {@link Integer} article number to remove
     * @return true if article was successfully removed, false otherwise
     */
    public boolean removeArticle(int articleNo) {
        CartItem existingItem = findItem(articleNo);
        if (existingItem != null) {
            items.remove(existingItem);
            return true;
        }
        return false;
    }

    /**
     * Finds a CartItem in the cart by its article number.
     * @param articleNo {@link Integer} article number to search for
     * @return {@link CartItem} if found, null otherwise
     */
    private CartItem findItem(int articleNo) {
        for (CartItem item : items) {
            if (item.getArticleNo() == articleNo) {
                return item;
            }
        }
        return null;
    }
}
