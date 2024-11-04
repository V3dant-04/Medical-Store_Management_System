package medicalmanagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportManager {
    private InventoryManager inventoryManager;

    public ReportManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public List<Medicine> lowStockReport(int threshold) {
        List<Medicine> lowStock = new ArrayList<>();
        for (Medicine medicine : inventoryManager.getInventory().values()) {
            if (medicine.getQuantity() < threshold) {
                lowStock.add(medicine);
            }
        }
        return lowStock;
    }

    public List<Medicine> expiredMedicines(String currentDate) {
        List<Medicine> expired = new ArrayList<>();
        LocalDate current = LocalDate.parse(currentDate);
        for (Medicine medicine : inventoryManager.getInventory().values()) {
            LocalDate expiry = LocalDate.parse(medicine.getExpiryDate());
            if (expiry.isBefore(current)) {
                expired.add(medicine);
            }
        }
        return expired;
    }
}
