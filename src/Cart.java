import java.util.*;

public class Cart {
    private final List<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int qty) {
        items.add(new CartItem(product, qty));
    }
    public boolean isEmpty() {
        return items.isEmpty();
    }
    public List<CartItem> getItems() {
        return items;
    }
}
