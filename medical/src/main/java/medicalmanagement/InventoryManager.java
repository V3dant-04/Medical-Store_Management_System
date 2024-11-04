package medicalmanagement;

import java.io.*;
import java.util.HashMap;

public class InventoryManager {
    private HashMap<String, Medicine> inventory;
    private static final String FILE_NAME = "inventory.dat";

    public InventoryManager() {
        inventory = new HashMap<>();
        loadInventory(); // Ensure inventory is loaded on initialization
    }

    public HashMap<String, Medicine> getInventory() {
        return inventory;
    }

    public void addMedicine(Medicine medicine) {
        inventory.put(medicine.getId(), medicine);
        saveInventory();
    }

    public void deleteMedicine(String id) {
        inventory.remove(id);
        saveInventory();
    }

    public Medicine getMedicine(String id) {
        return inventory.get(id);
    }

    public void saveInventory() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(inventory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadInventory() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            inventory = (HashMap<String, Medicine>) ois.readObject();
        } catch (EOFException e) {
            // This exception occurs when the file is empty (first run)
            System.out.println("No previous inventory found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
