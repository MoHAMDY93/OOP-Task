public abstract class Product { 
    private String name;
    private double price;
    private int quantity;

    // Constructor
    public Product(String name , double price , int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Setters & Getters
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public double getPrice() { return price; }
    
    // Reduce quantity method for using when adding products into cart
    // Trhowing exception when teh amount is larger than the available quantity
    public void ReduceQuantity(int amount) {
        if(amount > quantity) {
            throw new IllegalStateException("No Enough Quantity!");
        }
        quantity -= amount;
    }

    // Those two charcterstics will differ from a product to another 
    public abstract boolean isExpired();
    public abstract boolean requiresShipping();
}
