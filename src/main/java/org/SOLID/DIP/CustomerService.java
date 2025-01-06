package org.SOLID.DIP;

import org.SOLID.LSP.Customer;

public interface CustomerService {
    Customer getCustomer(String customerId);
    void saveCustomer(Customer customer);
    void displayOrderHistory(Customer customer);
}

