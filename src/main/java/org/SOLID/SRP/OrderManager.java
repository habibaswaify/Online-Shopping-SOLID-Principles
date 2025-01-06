package org.SOLID.SRP;

import org.SOLID.DIP.OrderService;
import org.SOLID.LSP.Customer;
import org.SOLID.general_classes.Item;
import org.SOLID.general_classes.Order;
import org.SOLID.general_classes.OrderStatus;

// Single Responsibility Principle Application: Separate class to manage orders
public class OrderManager implements OrderService {

    // Create a new order for customer
    @Override
    public void createOrder(Customer customer) {
        Order order = new Order();
        customer.getOrders().put(order.getOrderID(),order );

    }
    // Add item to the cart
    @Override
    public void addItemToOrder(Order order, Item item) {
        if(order.getStatus() == OrderStatus.Pending) {
            order.getItems().add(item);
        }
    }
    // Remove item from the cart
    @Override
    public void removeItemFromOrder(Order order, Item item) {
        if(order.getStatus() == OrderStatus.Pending){
            order.getItems().remove(item);
        }
    }

    // Apply discount to the total
    @Override
    public void applyDiscountToOrder(Order order, double discountPercentage) {
        double total = order.getTotal();
        double discount = total * discountPercentage;
        order.setTotal(total - discount);
        System.out.println("Applied " + discountPercentage * 100 + "% discount to order " + order.getOrderID());
    }
    // Calculate total
    @Override
    public void calculateTotal(Order order) {
        double total = 0;
        for (Item item : order.getItems()) {
            total += item.getItemPrice();
        }
        order.setTotal(total);
        System.out.println("Calculated total (without discount) for order " + order.getOrderID() + ": $" + total);
    }

    @Override
    public void saveOrder(Order order) {

    }
}
