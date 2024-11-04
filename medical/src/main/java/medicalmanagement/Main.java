package medicalmanagement;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryManager inventoryManager = new InventoryManager();
            BillingManager billingManager = new BillingManager(inventoryManager);
            ReportManager reportManager = new ReportManager(inventoryManager);
            SupplierManager supplierManager = new SupplierManager();

            JFrame frame = new JFrame("Medical Store Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 500);
            frame.setLayout(new GridLayout(3, 3));

            JButton addMedicineButton = new JButton("Add Medicine");
            JButton viewMedicineButton = new JButton("View Medicine");
            JButton editMedicineButton = new JButton("Edit Medicine");
            JButton deleteMedicineButton = new JButton("Delete Medicine");
            JButton generateBillButton = new JButton("Generate Bill");
            JButton generateReportButton = new JButton("Generate Report");
            JButton addSupplierButton = new JButton("Add Supplier");
            JButton viewSuppliersButton = new JButton("View Suppliers");
            JButton removeSupplierButton = new JButton("Remove Supplier");

            addMedicineButton.addActionListener(e -> {
                try {
                    String id = JOptionPane.showInputDialog("Enter Medicine ID:");
                    String name = JOptionPane.showInputDialog("Enter Medicine Name:");
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Enter Price:"));
                    String expiryDate = JOptionPane.showInputDialog("Enter Expiry Date (YYYY-MM-DD):");
                    inventoryManager.addMedicine(new Medicine(id, name, quantity, price, expiryDate));
                    JOptionPane.showMessageDialog(frame, "Medicine added successfully.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values for quantity and price.");
                }
            });

            viewMedicineButton.addActionListener(e -> {
                String id = JOptionPane.showInputDialog("Enter Medicine ID to View:");
                Medicine medicine = inventoryManager.getMedicine(id);
                if (medicine != null) {
                    JOptionPane.showMessageDialog(frame, medicine.toString());
                } else {
                    JOptionPane.showMessageDialog(frame, "Medicine not found.");
                }
            });
            

            editMedicineButton.addActionListener(e -> {
                String id = JOptionPane.showInputDialog("Enter Medicine ID to Edit:");
                Medicine medicine = inventoryManager.getMedicine(id);
                if (medicine != null) {
                    String name = JOptionPane.showInputDialog("Enter new Medicine Name:", medicine.getName());
                    int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter new Quantity:", medicine.getQuantity()));
                    double price = Double.parseDouble(JOptionPane.showInputDialog("Enter new Price:", medicine.getPrice()));
                    String expiryDate = JOptionPane.showInputDialog("Enter new Expiry Date (YYYY-MM-DD):", medicine.getExpiryDate());

                    // Update the medicine details
                    inventoryManager.deleteMedicine(id);  // Remove old entry
                    inventoryManager.addMedicine(new Medicine(id, name, quantity, price, expiryDate));  // Add updated entry
                    JOptionPane.showMessageDialog(frame, "Medicine updated successfully.");
                } else {
                    JOptionPane.showMessageDialog(frame, "Medicine not found.");
                }
            });

            deleteMedicineButton.addActionListener(e -> {
                String id = JOptionPane.showInputDialog("Enter Medicine ID to Delete:");
                inventoryManager.deleteMedicine(id);
                JOptionPane.showMessageDialog(frame, "Medicine deleted successfully.");
            });

            generateBillButton.addActionListener(e -> {
                String id = JOptionPane.showInputDialog("Enter Medicine ID for Billing:");
                int quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter Quantity:"));
                billingManager.addToCart(id, quantity);
                double totalBill = billingManager.generateBill();
                JOptionPane.showMessageDialog(frame, "Total Bill: " + totalBill);
            });

            generateReportButton.addActionListener(e -> {
                List<Medicine> lowStock = reportManager.lowStockReport(5);
                List<Medicine> expired = reportManager.expiredMedicines("2024-10-31");

                StringBuilder report = new StringBuilder("Low Stock:\n");
                for (Medicine med : lowStock) {
                    report.append(med.getName()).append(" - ").append(med.getQuantity()).append("\n");
                }

                report.append("\nExpired Medicines:\n");
                for (Medicine med : expired) {
                    report.append(med.getName()).append(" - Expired on: ").append(med.getExpiryDate()).append("\n");
                }

                JOptionPane.showMessageDialog(frame, report.toString());
            });

            addSupplierButton.addActionListener(e -> {
                String id = JOptionPane.showInputDialog("Enter Supplier ID:");
                String name = JOptionPane.showInputDialog("Enter Supplier Name:");
                supplierManager.addSupplier(id, name);
                JOptionPane.showMessageDialog(frame, "Supplier added successfully.");
            });

            viewSuppliersButton.addActionListener(e -> {
                List<SupplierManager.Supplier> suppliers = supplierManager.listSuppliers();
                StringBuilder supplierList = new StringBuilder("Suppliers:\n");
                for (SupplierManager.Supplier supplier : suppliers) {
                    supplierList.append(supplier.toString()).append("\n");
                }
                JOptionPane.showMessageDialog(frame, supplierList.toString());
            });

            removeSupplierButton.addActionListener(e -> {
                String id = JOptionPane.showInputDialog("Enter Supplier ID to Remove:");
                supplierManager.removeSupplier(id);
            });

            frame.add(addMedicineButton);
            frame.add(viewMedicineButton);
            frame.add(editMedicineButton);
            frame.add(deleteMedicineButton);
            frame.add(generateBillButton);
            frame.add(generateReportButton);
            frame.add(addSupplierButton);
            frame.add(viewSuppliersButton);
            frame.add(removeSupplierButton);
            frame.setVisible(true);
        });
    }
}
