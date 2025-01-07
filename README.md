# Online-Shopping-SOLID-Principles

A simple Java application mimicking an online shopping platform, demonstrating the application of SOLID design
principles.
- - -
# Table of Contents
1. [Single Responsibility Principle (SRP)](#single-responsibility-principle-srp)
2. [Open/Closed Principle (OCP)](#openclosed-principle-ocp)
3. [Liskov Substitution Principle (LSP)](#liskov-substitution-principle-lsp)
4. [Interface Segregation Principle (ISP)](#interface-segregation-principle-isp)
5. [Dependency Inversion Principle (DIP)](#dependency-inversion-principle-dip)

---

- ## Single Responsibility Principle (SRP)

    - **Description**: A class should have only one reason to change, meaning it should have only one job or
      responsibility. This helps in keeping the codebase clean and easy to maintain.

    - **Key Components**:
        - `OrderManager`: Handles order-related operations such as creating an order, adding items, and applying
          discounts.
        - `PaymentService`: Handles the payment processing, including validating and processing payments.
        - `NotificationService`: Responsible for notifying customers (e.g., via SMS, email) about the order status.

    - **Features**:
        - **Separation of Concerns**: Each class focuses on a single responsibility, which makes it easier to modify or
          extend specific parts of the system without affecting others.
        - **Maintainability**: If there is a change in one functionality (e.g., changing the way payments are
          processed), only the relevant class (`PaymentService`) needs to be modified, without touching other classes.
        - **Testability**: With each class having one responsibility, it becomes easier to write focused unit tests,
          ensuring each part of the system behaves as expected.

- - -

- ## Open/Closed Principle (OCP)

    - **Description**: Classes should be open for extension but closed for modification. This principle helps make the system more flexible, allowing new functionality to be added without altering existing code.

    - **Key Components**:
        - `PaymentProcessor`: A base class or interface that defines the common functionality for processing payments.
        - `CashPaymentProcessor`, `CreditCardPaymentProcessor`, `PayPalPaymentProcessor`: Concrete implementations of the `PaymentProcessor` class that handle specific payment methods.
        - `INotifier`: An interface defining methods for notifications.
        - `EmailNotifier`, `SMSNotifier`: Concrete implementations of the `INotifier` interface that handle sending notifications via email and SMS, respectively.

    - **Features**:
        - **Extensibility**: New payment processors or notification methods can be added without modifying existing classes, adhering to the open/closed principle.
        - **Maintainability**: New functionality can be added by creating new subclasses or implementations, without altering existing code, reducing the risk of introducing bugs.
        - **Flexibility**: You can introduce new types of notifications or payment processors as the platform grows, such as adding a new payment method (e.g., Bitcoin) or a new notification method (e.g., Push Notification).

- - -

- ## Liskov Substitution Principle (LSP)

    - **Description**: Derived classes should be substitutable for their base class without altering the correctness of
      the program.

    - **Key Components**:
        - `Customer`: The base class representing a general customer.
        - `RegularCustomer`: A derived class for customers with standard privileges.
        - `PremiumCustomer`: A derived class for customers with premium privileges.

    - **Features**:
        - Ensures all derived classes (`RegularCustomer` and `PremiumCustomer`) respect the behavior defined in
          `Customer`.
        - Avoids overriding or altering functionality in a way that violates the expected behavior of the base class.
        - Supports seamless integration of new customer types without breaking existing functionality.

- - -

- ## Interface Segregation Principle (ISP)

    - **Description**: A class should not be forced to implement interfaces it does not use. Interfaces should be small
      and focused on specific functionalities.

    - **Key Components**:
        - `Validatable`: Defines the method `validatePayment`, ensuring only classes dealing with payment validation
          implement it.
        - `Refundable`: Defines the method `refundPayment`, allowing only relevant classes to handle refunds.

    - **Features**:
        - **Separation of Concerns**: Each interface has a single, focused responsibility, making the code modular and
          maintainable.
        - **Flexibility**: Classes only implement the interfaces they actually need, avoiding unnecessary dependencies.
        - **Extensibility**: Adding new functionalities (e.g., new operations) does not impact unrelated classes.

- - -

- ## Dependency Inversion Principle (DIP)

    - **Description**: High-level modules should not depend on low-level modules. Both should depend on abstractions.
      Abstractions should not depend on details; details should depend on abstractions.

    - **Key Components**:
        - `CustomerService`: An interface that abstracts customer operations (e.g., retrieving or saving customer data).
        - `InMemoryCustomerService`: A concrete implementation of `CustomerService` that uses in-memory storage.
        - `OrderService`: An interface defining order-related operations, such as creating orders, applying discounts,
          and calculating totals.

    - **Features**:
        - **Abstraction**: Separates high-level business logic from low-level implementations.
        - **Flexibility**: Easily swap service implementations (e.g., `InMemoryCustomerService` with a database-backed
          service) without affecting other parts of the system.
        - **Modularity**: Encourages dependency injection, making the application loosely coupled and testable.
