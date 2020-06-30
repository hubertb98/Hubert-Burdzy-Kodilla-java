package com.kodilla.good.patterns.challenges.order;

public class BankTransferPaymentService implements PaymentService {
    @Override
    public boolean pay(Invoice invoice) {
        System.out.println("Bank transfer payment has been completed!");
        return true;
    }
}
