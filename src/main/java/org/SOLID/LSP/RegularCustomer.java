package org.SOLID.LSP;

public class RegularCustomer extends Customer {

    public RegularCustomer(String name, String phoneNumber, String email) {
        super(name, phoneNumber,email);
    }

    @Override
    public double getDiscount() {
        // Regular customers get no discount
        return 0;
    }
}
