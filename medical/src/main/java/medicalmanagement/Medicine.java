package medicalmanagement;

import java.io.Serializable;

public class Medicine implements Serializable {
    private String id;
    private String name;
    private int quantity;
    private double price;
    private String expiryDate;

    public Medicine(String id, String name, int quantity, double price, String expiryDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public String toString() {
        return "Medicine ID: " + id + "\n" +
               "Name: " + name + "\n" +
               "Quantity: " + quantity + "\n" +
               "Price: $" + price + "\n" +
               "Expiry Date: " + expiryDate;
    }
}
