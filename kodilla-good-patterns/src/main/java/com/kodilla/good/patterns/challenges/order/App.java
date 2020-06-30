package com.kodilla.good.patterns.challenges.order;

public class App {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = new OrderRequestRetriever().retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(new BankTransferPaymentService(), new ProductOrderService(), new CourierDeliveryService());
        orderProcessor.process(orderRequest);
    }
}
