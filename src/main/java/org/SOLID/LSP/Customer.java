package org.SOLID.LSP;

import org.SOLID.general_classes.Order;
import java.util.HashMap;
import java.util.UUID;

// Liskov Substitution Principle Application: the two subclasses of this customer class are substitutable with each other without breaking functionality
public abstract class Customer {
    private String name;
    private String phoneNumber;
    private String email;
    private final HashMap<String, Order> orders;
    private final String id;
    private boolean hasDiscount;
    public Customer(String name, String phoneNumber, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.orders = new HashMap<>();
    }

    public String getID() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public HashMap<String, Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.put(order.getOrderID(), order);
    }

    // Protected method to differentiate between the features of regular and premium customers
    protected void setHasDiscount(boolean hasDiscount) {
        this.hasDiscount = hasDiscount;
    }
    public boolean hasDiscount(){
        return this.hasDiscount;
    }
}
