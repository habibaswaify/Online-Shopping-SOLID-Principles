package org.SOLID.OCP;

import org.SOLID.general_classes.Order;
// Open Closed Principle Application: Different classes for payment processing that implement the same interface.
// Interface Segregation Principle : Different interfaces are implemented by the same objects in order to prevent the unnecessary implementation of methods
public interface PaymentProcessor {
        void processPayment(Order order, double amount);
}
