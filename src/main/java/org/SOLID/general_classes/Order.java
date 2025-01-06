package org.SOLID.general_classes;

import java.util.ArrayList;
import java.util.UUID;

public class Order {
    // A list of items added to the cart
    private final ArrayList<Item> items;
    // The total price
    private double total;
    private final String orderID;
    private OrderStatus status;

    public Order() {
        this.status = OrderStatus.Pending;
        this.items = new ArrayList<>();
        this.total = 0;
        this.orderID = UUID.randomUUID().toString();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setTotal(double amount) {
        this.total = amount;
    }

    public double getTotal() {
        return total;
    }

    public String getOrderID() {
        return orderID;
    }

    public OrderStatus getStatus() {
        return status;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

}
