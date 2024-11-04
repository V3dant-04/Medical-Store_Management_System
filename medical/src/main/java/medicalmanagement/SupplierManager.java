package medicalmanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SupplierManager {
    private Stack<Supplier> suppliers;

    public SupplierManager() {
        suppliers = new Stack<>();
    }

    public void addSupplier(String id, String name) {
        try {
            if (id == null || id.isEmpty() || name == null || name.isEmpty()) {
                throw new IllegalArgumentException("Supplier ID and name cannot be empty.");
            }
            suppliers.push(new Supplier(id, name));
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding supplier: " + e.getMessage());
        }
    }

    public Supplier getLastSupplier() {
        return suppliers.isEmpty() ? null : suppliers.peek();
    }

    public void removeLastSupplier() {
        if (!suppliers.isEmpty()) {
            suppliers.pop();
        } else {
            System.out.println("No suppliers to remove.");
        }
    }

    public boolean isSupplierAvailable() {
        return !suppliers.isEmpty();
    }

    public List<Supplier> listSuppliers() {
        return new ArrayList<>(suppliers);
    }

    public void removeSupplier(String id) {
        Stack<Supplier> tempStack = new Stack<>();
        boolean found = false;

        while (!suppliers.isEmpty()) {
            Supplier supplier = suppliers.pop();
            if (supplier.getId().equals(id)) {
                found = true;
                break;
            }
            tempStack.push(supplier);
        }

        // Restore the other suppliers back to the original stack
        while (!tempStack.isEmpty()) {
            suppliers.push(tempStack.pop());
        }

        if (found) {
            System.out.println("Supplier with ID " + id + " removed successfully.");
        } else {
            System.out.println("Supplier with ID " + id + " not found.");
        }
    }

    // Inner class to represent Supplier with ID and Name
    static class Supplier {
        private String id;
        private String name;

        public Supplier(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Supplier ID: " + id + ", Name: " + name;
        }
    }
}
