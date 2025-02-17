import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    public void addToCart(String product) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + 1);
        } else {
            System.out.println("Product not found!");
        }
    }

    public void displayCartOrder() {
        System.out.println("Cart Order: " + cart);
    }

    public void displaySortedByPrice() {
        TreeMap<Double, String> sortedProducts = new TreeMap<>();
        for (Map.Entry<String, Double> entry : productPrices.entrySet()) {
            sortedProducts.put(entry.getValue(), entry.getKey());
        }
        System.out.println("Products Sorted by Price: " + sortedProducts);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct("Apple", 1.5);
        cart.addProduct("Banana", 0.8);
        cart.addProduct("Orange", 1.2);
        
        cart.addToCart("Apple");
        cart.addToCart("Banana");
        cart.addToCart("Apple");
        
        cart.displayCartOrder();
        cart.displaySortedByPrice();
    }
}
