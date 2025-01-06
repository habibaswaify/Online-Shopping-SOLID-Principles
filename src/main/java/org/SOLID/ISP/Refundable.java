package org.SOLID.ISP;

import org.SOLID.general_classes.Order;

public interface Refundable {
    void refundPayment(Order order,double amount);
}
