import java.util.ArrayList;
import java.util.Scanner;


class InventoryItem {
    private int id;
    private String name;
    private String sku;
    private String category;
    private int quantity;
    private String supplier;
    private double price;
    private String location;

    public InventoryItem(int id, String name, String sku, String category, int quantity, String supplier, double price, String location) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.category = category;
        this.quantity = quantity;
        this.supplier = supplier;
        this.price = price;
        this.location = location;
    }

    
    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getSupplier() { return supplier; }
    public void setSupplier(String supplier) { this.supplier = supplier; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", SKU: " + sku + ", Category: " + category + ", Quantity: " + quantity + ", Supplier: " + supplier + ", Price: " + price + ", Location: " + location;
    }
}


public class InventoryManagementSystem {
    private static ArrayList<InventoryItem> inventory = new ArrayList<>();
    private static int nextId = 1; 
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Inventory Item");
            System.out.println("2. Update Inventory Item");
            System.out.println("3. Delete Inventory Item");
            System.out.println("4. View Inventory");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addItem();
                case 2 -> updateItem();
                case 3 -> deleteItem();
                case 4 -> viewInventory();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addItem() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter supplier: ");
        String supplier = scanner.nextLine();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter location: ");
        String location = scanner.nextLine();

        InventoryItem item = new InventoryItem(nextId++, name, sku, category, quantity, supplier, price, location);
        inventory.add(item);
        System.out.println("Item added successfully!");
    }

    private static void updateItem() {
        System.out.print("Enter the ID of the item to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        InventoryItem item = findItemById(id);
        if (item == null) {
            System.out.println("Item not found!");
            return;
        }

        System.out.print("Enter new name (" + item.getName() + "): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) item.setName(name);

        System.out.print("Enter new SKU (" + item.getSku() + "): ");
        String sku = scanner.nextLine();
        if (!sku.isEmpty()) item.setSku(sku);

        System.out.print("Enter new category (" + item.getCategory() + "): ");
        String category = scanner.nextLine();
        if (!category.isEmpty()) item.setCategory(category);

        System.out.print("Enter new quantity (" + item.getQuantity() + "): ");
        String quantityStr = scanner.nextLine();
        if (!quantityStr.isEmpty()) item.setQuantity(Integer.parseInt(quantityStr));

        System.out.print("Enter new supplier (" + item.getSupplier() + "): ");
        String supplier = scanner.nextLine();
        if (!supplier.isEmpty()) item.setSupplier(supplier);

        System.out.print("Enter new price (" + item.getPrice() + "): ");
        String priceStr = scanner.nextLine();
        if (!priceStr.isEmpty()) item.setPrice(Double.parseDouble(priceStr));

        System.out.print("Enter new location (" + item.getLocation() + "): ");
        String location = scanner.nextLine();
        if (!location.isEmpty()) item.setLocation(location);

        System.out.println("Item updated successfully!");
    }

    private static void deleteItem() {
        System.out.print("Enter the ID of the item to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        InventoryItem item = findItemById(id);
        if (item != null) {
            inventory.remove(item);
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Item not found!");
        }
    }

    private static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for (InventoryItem item : inventory) {
            System.out.println(item);
        }
    }

    private static InventoryItem findItemById(int id) {
        for (InventoryItem item : inventory) {
            if (item.getId() == id) return item;
        }
        return null;
    }
}
