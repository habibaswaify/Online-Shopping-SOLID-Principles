package org.SOLID;

import org.SOLID.DIP.CustomerService;
import org.SOLID.DIP.InMemoryCustomerService;
import org.SOLID.DIP.OrderService;
import org.SOLID.LSP.Customer;
import org.SOLID.LSP.PremiumCustomer;
import org.SOLID.LSP.RegularCustomer;
import org.SOLID.OCP.*;
import org.SOLID.SRP.NotificationService;
import org.SOLID.SRP.OrderManager;
import org.SOLID.general_classes.Item;
import org.SOLID.general_classes.Order;

import java.util.Arrays;

public class Main {
    private final CustomerService customerService;
    private final OrderService orderService;
    private final PaymentProcessor paymentProcessor;
    private final NotificationService notificationService;

    // Constructor injection for all dependencies
    public Main(CustomerService customerService, OrderService orderService,
                PaymentProcessor paymentProcessor, NotificationService notificationService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.paymentProcessor = paymentProcessor;
        this.notificationService = notificationService;
    }

    public void processOrder(String customerId) {
        // Get customer
        Customer customer = customerService.getCustomer(customerId);

        // Create order and add items
        Order order = new Order();
        orderService.createOrder(customer);
        Item item1 = new Item("Laptop", 999.99);
        Item item2 = new Item("Wireless Mouse", 25.50);
        orderService.addItemToOrder(order, item1);
        orderService.addItemToOrder(order, item2);

        // Apply discount and calculate total
        if(customer.hasDiscount()){
            double discount = .2;
            orderService.calculateTotal(order);
            orderService.applyDiscountToOrder(order, discount);
        }

        // Process payment
        paymentProcessor.processPayment(order, order.getTotal());

        // Send notifications (email and SMS)
        notificationService.notifyCustomer();
    }

    public static void main(String[] args) {
        // Example customers
//        RegularCustomer customer = new RegularCustomer("Joe", "123-456-789", "joe@gmail.com");
        PremiumCustomer customer = new PremiumCustomer("Jane", "987-654-321","jane@hotmail.com");
        // Services
        CustomerService customerService = new InMemoryCustomerService();
        customerService.saveCustomer(customer);

        OrderService orderService = new OrderManager();
        Main mainApp = getMain(customer, customerService, orderService);

        // Process an order
        mainApp.processOrder(customer.getID());
    }

    private static Main getMain(Customer customer, CustomerService customerService, OrderService orderService) {
        PaymentProcessor paymentProcessor = new CreditCardPaymentProcessor();

        // Notification services (Email and SMS)
        Order order = new Order();
        INotifier emailNotifier = new EmailNotifier(customer,order);
        INotifier smsNotifier = new SMSNotifier(customer, order);
        NotificationService notificationService = new NotificationService(Arrays.asList(emailNotifier, smsNotifier));

        // Initialize the application
        return new Main(customerService, orderService, paymentProcessor, notificationService);
    }
}
