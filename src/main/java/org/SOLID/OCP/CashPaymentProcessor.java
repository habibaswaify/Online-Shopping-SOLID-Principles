package org.SOLID.OCP;

import org.SOLID.general_classes.Order;

public class CashPaymentProcessor implements PaymentProcessor {

    @Override
    public void processPayment(Order order, double amount) {
        System.out.println("Processing Cash Payment for Order ID: " + order.getOrderID() + " Amount: $" + order.getTotal());
    }
}
