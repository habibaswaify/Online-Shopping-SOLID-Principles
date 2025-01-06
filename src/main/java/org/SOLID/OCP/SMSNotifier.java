package org.SOLID.OCP;

import org.SOLID.LSP.Customer;
import org.SOLID.general_classes.Order;

public class SMSNotifier implements INotifier {
    private final Customer customer;
    private final Order order;

    public SMSNotifier(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    @Override
    public void notifyCustomer() {
        System.out.println("Sending SMS to " + customer.getPhoneNumber() + ": " +
                "Your order " + order.getOrderID() + " is " + order.getStatus() + ".");
    }
}