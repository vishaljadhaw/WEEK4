// Import statements should be at the top of the file
import java.util.ArrayList;
import java.util.List;

// Abstract class for Warehouse Items
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Item: " + name;
    }
}

// Electronics class extending WarehouseItem
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Electronics - " + super.toString();
    }
}

// Groceries class extending WarehouseItem
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Groceries - " + super.toString();
    }
}

// Furniture class extending WarehouseItem
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Furniture - " + super.toString();
    }
}

// Generic class Storage to store items of type WarehouseItem or its subclasses
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    // Add item to storage
    public void addItem(T item) {
        items.add(item);
    }

    // Remove item from storage
    public void removeItem(T item) {
        items.remove(item);
    }

    // Get all items in storage
    public List<T> getItems() {
        return items;
    }
}

// Warehouse class for displaying items using wildcards
 class Warehouse {
    // Method to display all items using wildcard
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class for testing the system
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        // Create storage for each item type
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to storage
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        groceriesStorage.addItem(new Groceries("Apples"));
        groceriesStorage.addItem(new Groceries("Bananas"));

        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem(new Furniture("Dining Table"));

        // Display items using wildcard
        System.out.println("Electronics in storage:");
        Warehouse.displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries in storage:");
        Warehouse.displayItems(groceriesStorage.getItems());

        System.out.println("\nFurniture in storage:");
        Warehouse.displayItems(furnitureStorage.getItems());
    }
}
