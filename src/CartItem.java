public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity > product.getQuantity()) {
            throw new IllegalStateException("Invalid quantity for " + product.getName());
        }
        this.product = product;
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double totalPrice() {
        return product.getPrice() * quantity;
    }
}
