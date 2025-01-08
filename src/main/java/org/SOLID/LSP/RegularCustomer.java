package org.SOLID.LSP;

public class RegularCustomer extends Customer {

    public RegularCustomer(String name, String phoneNumber, String email) {
        super(name, phoneNumber,email);
        this.setHasDiscount(false);
    }

}
