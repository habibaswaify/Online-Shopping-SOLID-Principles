package org.SOLID.DIP;

import org.SOLID.general_classes.Item;
import org.SOLID.LSP.Customer;
import org.SOLID.general_classes.Order;

public interface OrderService {
    void createOrder(Customer customer);
    void addItemToOrder(Order order, Item item);
    void removeItemFromOrder(Order order, Item item);
    void applyDiscountToOrder(Order order, double discountPercentage);
    void calculateTotal(Order order);
    void saveOrder(Order order);
}
