package org.SOLID.LSP;

public class PremiumCustomer extends Customer {


    public PremiumCustomer(String name, String phoneNumber,String email) {
        super(name, phoneNumber,email);
        this.setHasDiscount(true);
    }

}

