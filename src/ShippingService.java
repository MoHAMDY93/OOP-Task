import java.util.*;

public class ShippingService {
    private double PricePerKG = 30.0;
    private double total = 0.0;
    private double totalWeight(List<Product> items) {
        for (Product item : items) {
            if(!(item instanceof Shippable)) continue;
            total += (((Shippable)item).getWeight());
        }
        return total;
    }

    public double calculateFee(List<Product> items) {
        double weight = totalWeight(items);
        return weight * PricePerKG;
    }

    public void ship(List<Product> items) {
        System.out.println("** Shipment notice **");
        Map<String, Double> summary = new LinkedHashMap<>();
        for (Product item : items) {
            if(!(item instanceof Shippable)) continue;
            summary.put(item.getName() , summary.getOrDefault(item.getName(), 0.0) + (((Shippable)item).getWeight()));
        }
        summary.forEach((name, wt) ->
            System.out.printf("%s\t%.2fkg%n", name, wt)
        );
        System.out.printf("Total package weight: %.2fkg%n%n", totalWeight(items));
    }
}
