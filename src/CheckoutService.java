import java.util.*;
public class CheckoutService {
    private ShippingService shipper;

    public CheckoutService(ShippingService shipper) {
        this.shipper = shipper;
    }
    public void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) 
            throw new IllegalStateException("Cart is empty");

        double subtotal = 0;
        List<Product> toShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            if (p.isExpired())
                throw new IllegalStateException(p.getName() + " is expired");
            if (qty > p.getQuantity())
                throw new IllegalStateException(p.getName() + " out of stock");

            subtotal += item.totalPrice();

            if (p.requiresShipping()) {
                for (int i = 0; i < qty; i++) {
                    toShip.add(p);
                }
            }
        }
        double shippingFee = toShip.isEmpty() 
                            ? 0 
                            : shipper.calculateFee(toShip);

        double total = subtotal + shippingFee;

        customer.debit(total);
        cart.getItems().forEach(i -> 
            i.getProduct().ReduceQuantity(i.getQuantity())
        );

        if (!toShip.isEmpty()) {
            shipper.ship(toShip);
        }

        System.out.println("** Checkout receipt **");
        cart.getItems().forEach(item -> {
            System.out.printf("%dx %s\t%.2f%n",
                item.getQuantity(),
                item.getProduct().getName(),
                item.totalPrice());
        });
        System.out.println("----------------------");
        System.out.printf("Subtotal\t%.2f%n", subtotal);
        System.out.printf("Shipping\t%.2f%n", shippingFee);
        System.out.printf("Amount\t\t%.2f%n", total);
    }
}
