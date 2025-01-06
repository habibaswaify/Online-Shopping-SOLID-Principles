package org.SOLID.LSP;

public class PremiumCustomer extends Customer {

    private final double discountRate;

    public PremiumCustomer(String name, String phoneNumber,String email, double discountRate) {
        super(name, phoneNumber,email);
        this.discountRate = discountRate;
    }

    @Override
    public double getDiscount() {
        // Premium customers get a specific discount
        return discountRate;
    }
}

