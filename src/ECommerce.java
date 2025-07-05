import java.time.LocalDate;

public class ECommerce {
    public static void main(String[] args) throws Exception {
        var cheese = new ExpirableShippableProduct(
            "Cheese",   50, 10,
            LocalDate.of(2025,7,10), 0.5
        );
        var tv = new ShippableProduct("TV",  1000, 2, 15.0);
        var card = new StandardProduct("Mobile Scratch Card", 20, 5);

        Customer alice = new Customer("Alice", 2000);
        Cart cart = new Cart();
        cart.addItem(cheese, 5);
        cart.addItem(tv, 1);
        cart.addItem(card, 3);
        
        CheckoutService checkout = new CheckoutService(new ShippingService());
        checkout.checkout(alice, cart);
    }
}
