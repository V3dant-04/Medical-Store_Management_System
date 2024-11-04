package medicalmanagement;

import java.util.LinkedList;
import java.util.Queue;

public class CustomerOrderQueue {
    private Queue<Medicine> orderQueue = new LinkedList<>();

    public void addOrder(Medicine order) {
        orderQueue.add(order);
    }

    public Medicine processOrder() {
        return orderQueue.poll();
    }

    public boolean hasOrders() {
        return !orderQueue.isEmpty();
    }
}
