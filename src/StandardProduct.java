// Not Expirable nor Shippable
public class StandardProduct extends Product {
    public StandardProduct(String name, double price, int qty) {
        super(name, price, qty);
    }

    @Override public boolean isExpired()         { return false; }
    @Override public boolean requiresShipping()  { return false; }
}
