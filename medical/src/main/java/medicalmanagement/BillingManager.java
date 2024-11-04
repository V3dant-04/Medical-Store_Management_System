package medicalmanagement;

import java.util.HashMap;

public class BillingManager {
    private InventoryManager inventoryManager;
    private HashMap<String, Integer> cart; // stores medicine ID and quantity

    public BillingManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
        this.cart = new HashMap<>();
    }

    // Adds medicine to the cart based on ID and quantity
    public void addToCart(String medicineId, int quantity) {
        cart.put(medicineId, quantity);
    }

    // Calculates the total bill based on medicines and quantities in the cart
    public double generateBill() {
        double totalBill = 0.0;
        for (String medicineId : cart.keySet()) {
            Medicine medicine = inventoryManager.getMedicine(medicineId);
            if (medicine != null) {
                int quantity = cart.get(medicineId);
                totalBill += medicine.getPrice() * quantity;
            }
        }
        return totalBill;
    }
}
