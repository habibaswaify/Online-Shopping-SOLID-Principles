package org.SOLID.SRP;

import org.SOLID.OCP.PaymentProcessor;
import org.SOLID.general_classes.Order;
// Single Responsibility Principle Application: Separate class to process payment
public class PaymentService {
    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment(Order order, double amount) {
        paymentProcessor.processPayment(order, amount);
    }
}