package teamrust;

import java.util.ArrayList;
import java.util.List;

class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ShoppingCartItem {
    private Product product;
    private int quantity;

    public ShoppingCartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

class ShoppingCart {
    private List<ShoppingCartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        ShoppingCartItem newItem = new ShoppingCartItem(product, quantity);
        items.add(newItem);
    }

    public void removeItem(Product product) {
        items.removeIf(item -> item.getProduct().getProductId() == product.getProductId());
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (ShoppingCartItem item : items) {
            totalPrice += item.getTotalPrice();
        }
        return totalPrice;
    }

    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (ShoppingCartItem item : items) {
            System.out.println(item.getProduct().getName() + " - Quantity: " + item.getQuantity() + " - Price: K"
                    + item.getTotalPrice());
        }
        System.out.println("Total Price: K" + getTotalPrice());
    }
}

public class ShoppingCartAssignment {
    public static void main(String[] args) {

        Product laptop = new Product(1, "Laptop", 19000.00);
        Product phone = new Product(2, "Phone", 7000.00);
        Product headphones = new Product(3, "Headphones", 300.00);

        ShoppingCart cart = new ShoppingCart();

        cart.addItem(laptop, 1);
        cart.addItem(phone, 2);
        cart.addItem(headphones, 1);

        cart.displayCart();

        cart.removeItem(phone);

        cart.displayCart();
    }
}
