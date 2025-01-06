package org.SOLID.OCP;


import org.SOLID.ISP.Refundable;
import org.SOLID.ISP.Validatable;
import org.SOLID.general_classes.Order;

public class PayPalPaymentProcessor implements PaymentProcessor , Refundable, Validatable {
    @Override
    public void processPayment(Order order, double amount) {
        System.out.println("Processing PayPal Payment for Order ID: " + order.getOrderID() + " Amount: $" + order.getTotal());
    }
    @Override
    public void refundPayment(Order order,double amount) {
        System.out.println("Refunding PayPal payment of: " + amount);
        order.setTotal(order.getTotal() + amount);
    }

    @Override
    public void validatePayment() {
        System.out.println("Validating PayPal payment");
    }
}
