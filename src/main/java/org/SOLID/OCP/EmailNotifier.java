package org.SOLID.OCP;

import org.SOLID.LSP.Customer;
import org.SOLID.general_classes.Order;

public class EmailNotifier implements INotifier {
    Customer customer;
    Order order;

    public EmailNotifier(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }
    @Override
    public void notifyCustomer() {
        System.out.println("Sending email to " + customer.getName() + " at " +customer.getEmail() +
                " Your order " + order.getOrderID() + " is " + order.getStatus() + ".");
    }
}
