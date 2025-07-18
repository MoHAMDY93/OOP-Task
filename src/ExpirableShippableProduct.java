// Expirable & Shipable Products
import java.time.LocalDate;
public class ExpirableShippableProduct extends Product
    implements Expirable, Shippable
{
    private final LocalDate expiryDate;
    private final double weight;

    public ExpirableShippableProduct(String name, double price, int qty, LocalDate expiryDate, double weight) {
        super(name, price, qty);
        this.expiryDate = expiryDate;
        this.weight = weight;
    }
    
    @Override public LocalDate getExpiryDate()   { return expiryDate; }
    @Override public boolean isExpired()         { return Expirable.super.isExpired(); }
    @Override public double getWeight()          { return weight; }
    @Override public boolean requiresShipping()  { return true; }
}
