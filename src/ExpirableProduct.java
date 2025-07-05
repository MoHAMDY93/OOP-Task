// Expirable only products will need to have the date of expiration.
import java.time.LocalDate;
public class ExpirableProduct extends Product implements Expirable {
    private final LocalDate expiryDate;
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    @Override public LocalDate getExpiryDate() { return expiryDate; }
    @Override public boolean isExpired() { return Expirable.super.isExpired(); }
    @Override public boolean requiresShipping() { return false; }
}
