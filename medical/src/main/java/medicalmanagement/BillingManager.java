package medicalmanagement;

import java.util.HashMap;

public class BillingManager {
    private InventoryManager inventoryManager;
    private HashMap<String, Integer> cart; // Maps medicine ID to quantity

    public BillingManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.cart = new HashMap<>();
    }

    // Add a medicine to the cart
    public void addToCart(String id, int quantity) {
        Medicine medicine = inventoryManager.getMedicine(id);
        if (medicine != null) {
            if (medicine.getQuantity() >= quantity) {
                cart.put(id, cart.getOrDefault(id, 0) + quantity);
                System.out.println("Added to cart: " + quantity + " of " + medicine.getName());
            } else {
                System.out.println("Not enough stock for " + medicine.getName());
            }
        } else {
            System.out.println("Medicine not found in inventory.");
        }
    }

    // Generate the total bill and update inventory
    public double generateBill() {
        double total = 0.0;
        for (String id : cart.keySet()) {
            Medicine medicine = inventoryManager.getMedicine(id);
            if (medicine != null) {
                int quantity = cart.get(id);
                total += medicine.getPrice() * quantity;
                // Update the inventory after billing
                int newQuantity = medicine.getQuantity() - quantity;
                inventoryManager.updateQuantity(id, newQuantity);
            }
        }
        // Clear the cart after generating the bill
        cart.clear();
        return total;
    }
}
