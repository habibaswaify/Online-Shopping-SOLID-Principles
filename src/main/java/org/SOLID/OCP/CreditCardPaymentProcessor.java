package org.SOLID.OCP;

import org.SOLID.ISP.Validatable;
import org.SOLID.general_classes.Order;

public class CreditCardPaymentProcessor implements PaymentProcessor, Validatable {

    @Override
    public void processPayment(Order order, double amount) {
        System.out.println("Processing Credit Card Payment for Order ID: " + order.getOrderID() + " Amount: $" + order.getTotal());
    }
    @Override
    public void validatePayment() {
        System.out.println("Validating credit card payment");
    }
}

