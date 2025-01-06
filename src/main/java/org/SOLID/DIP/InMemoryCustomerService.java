package org.SOLID.DIP;

import org.SOLID.general_classes.Item;
import org.SOLID.LSP.Customer;
import org.SOLID.general_classes.Order;

import java.util.HashMap;
import java.util.Map;

public class InMemoryCustomerService implements CustomerService {
    private final Map<String, Customer> customerDatabase = new HashMap<>();

    @Override
    public Customer getCustomer(String customerId) {
        return customerDatabase.get(customerId);  // Get customer by ID
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDatabase.put(customer.getID(), customer);  // Save customer
    }
    // Retrieve customer's order history
    @Override
    public void displayOrderHistory(Customer customer) {

            System.out.println("Orders Made by Customer, "+customer.getName() + " :");
            for (Order order: customer.getOrders().values()){
                System.out.println("Order ID: "+order.getOrderID() + ", status:" + order.getStatus());
                for(Item item: order.getItems()){
                    System.out.println("Item: "+ item.getItemName() + ", price: $" + item.getItemPrice());
                }
            }

    }


}
