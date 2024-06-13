package onlineshop;

import onlineshop.merchandise.CartItem;
import onlineshop.merchandise.Plant;

import java.util.ArrayList;
import java.util.List;

// TODO: add JavaDoc like in {@link PlantMee}
public class Cart {
    final static int MAX_QUANTITY = 15;
    private List<CartItem> items = new ArrayList<>();

    public List<CartItem> getItems() {
        return items;
    }

    /**
     * Counts cart items and their quantity
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
     * Sums all cart items, taking their quantity into account
     * @return formattedNumber {@link String}
     */
    public String getSubtotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return PlantMee.df.format(total);
    }

    /**
     * Adds an article/plant to the cart
     * @param plant {@link Plant}
     */
    public void addArticle(Plant plant) {
        CartItem item = findItem(plant.getArticleNo());
        if (item == null) {
            item = new CartItem(plant);
            items.add(item);
        }
        // limit quantity
        if (item.getQuantity() <= MAX_QUANTITY) {
            item.increaseQuantity();
        }
    }

    public boolean increaseQuantity(int articleNo) {
        CartItem existingItem = findItem(articleNo);
        if (existingItem != null) {
            existingItem.increaseQuantity();
            return true;
        }
        return false;
    }

    /**
     * Decreases the quantity of an existing article.
     * If quantity sinks below 1, it removes the article and returns 'false'.
     * @param articleNo {@link Integer}
     * @return isArticleNotRemoved {@link Boolean}
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
     * Removes an article from the cart
     * @param articleNo {@link Integer}
     * @return wasSuccesful {@link Boolean}
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
     * Finds an article by its article number
     * @param articleNo {@link Integer}
     * @return existingItem {@link CartItem}
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
