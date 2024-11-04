package medicalmanagement;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Medicine> inventory;
    private static final String FILE_NAME = "inventory.dat";

    public InventoryManager() {
        inventory = new HashMap<>();
        loadInventory(); // Load inventory on initialization
    }

    // Get the current inventory
    public HashMap<String, Medicine> getInventory() {
        return inventory;
    }

    // Add a new medicine to the inventory
    public void addMedicine(Medicine medicine) {
        inventory.put(medicine.getId(), medicine);
        saveInventory();  // Save after adding new medicine
    }

    // Delete a medicine from the inventory
    public void deleteMedicine(String id) {
        inventory.remove(id);
        saveInventory();  // Save after deletion
    }

    // Retrieve a specific medicine by ID
    public Medicine getMedicine(String id) {
        return inventory.get(id);
    }

    // Update quantity of a specific medicine
    public void updateQuantity(String id, int newQuantity) {
        Medicine medicine = inventory.get(id);
        if (medicine != null) {
            medicine.setQuantity(newQuantity);
            saveInventory();  // Save the updated inventory
        }
    }

    // Save inventory data to a file
    private void saveInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load inventory data from a file
    @SuppressWarnings("unchecked")
    private void loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            inventory = (HashMap<String, Medicine>) ois.readObject();
        } catch (EOFException e) {
            // No previous inventory found (first-time use)
            System.out.println("No previous inventory found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
