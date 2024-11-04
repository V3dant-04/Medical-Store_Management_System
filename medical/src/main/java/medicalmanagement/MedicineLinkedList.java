package medicalmanagement;

import java.util.LinkedList;

public class MedicineLinkedList {
    private LinkedList<Medicine> medicines = new LinkedList<>();

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void removeMedicine(String id) {
        medicines.removeIf(med -> med.getId().equals(id));
    }

    public Medicine searchMedicine(String id) {
        for (Medicine med : medicines) {
            if (med.getId().equals(id)) return med;
        }
        return null;
    }

    public LinkedList<Medicine> getAllMedicines() {
        return medicines;
    }
}
