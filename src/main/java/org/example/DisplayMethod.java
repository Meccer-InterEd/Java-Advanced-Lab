package org.example;

import org.example.Interface_Payment_System.*;
import org.example.Lab01_Enum_Food_Delivery_Order.DeliveryMethod;
import org.example.Lab01_Enum_Food_Delivery_Order.Order;
import org.example.Lab01_Enum_Food_Delivery_Order.PaymentStatus;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Scanner;
import java.util.function.DoubleToIntFunction;

public class DisplayMethod {
    Scanner scanner = new Scanner(System.in);

    //Menu menu = new Menu();
    public void DisplayFoodDelivery() {

        Order order = new Order(
                "ORD-1001",
                "Lerato",
                new BigDecimal("249.99"),
                DeliveryMethod.STANDARD_DELIVERY
        );

        boolean running = true;

        while (running) {

            // display the menu
            System.out.println("======== FOOD DELIVERY SYSTEM =======");
            System.out.println("1. View payment status");
            System.out.println("2. Confirm payment");
            System.out.println("3. Mark payment as failed");
            System.out.println("4. Confirm order");
            System.out.println("5. Move order to next status");
            System.out.println("6. Cancel order");
            System.out.println("7. View order summary");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: "); // enter the option

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number"); // for invaild number
                scanner.nextLine();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    order.displayPaymentStatus();
                    break;
                case 2:
                    order.setPaymentStatus(PaymentStatus.PAID);
                    break;
                case 3:
                    order.setPaymentStatus(PaymentStatus.FAILED);
                    break;
                case 4:
                    order.confirmingOrder();
                    break;
                case 5:
                    order.nextStatus();
                    break;
                case 6:
                    order.cancelOrder();
                    break;
                case 7:
                    order.displayOrderSummary();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using the system.");

                default:
                    System.out.println("Invalid choice. Please select 1 to 7.");
            }
        }

        scanner.close();
    }


    public void DisplayPayment() {
        boolean running = true;
        while (running) {

            System.out.println("===== ONLINE STORE CHECKOUT =====");
            System.out.println("1. Card Payment");
            System.out.println("2. Instant EFT");
            System.out.println("3. Voucher Payment");
            System.out.println("4. Exit");
            System.out.print("Select your choice: ");

            String choice = scanner.nextLine().trim();

            PaymentMethod paymentMethod;

            switch (choice) {
                case "1":
                    paymentMethod = new CardPayment();
                    break;
                case "2":
                    paymentMethod = new InstantEftPayment();
                    break;
                case "3":
                    paymentMethod = new VoucherPayment();
                    break;
                case "4":
                    running = false;
                    System.out.println("Thank you for using the system.");
                    continue;

                default:
                    System.out.println("Invalid option. Choose 1, 2, 3, or 4.");
                    continue;
            }

            System.out.print("Enter payment amount: R");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Payment amount cannot be empty.");
                continue;
            }

            BigDecimal amount;

            try {
                amount = new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount. Enter a number, e.g. 250.00.");
                continue;
            }

            if (amount.compareTo(BigDecimal.ZERO) <= 0) {
                System.out.println("Amount must be greater than zero.");
                continue;
            }

            try {
                PaymentResult result = paymentMethod.pay(amount);

                if (result == null) {
                    System.out.println(
                            "No payment result was returned."
                    );
                    continue;
                }

                System.out.println("============ PAYMENT RECEIPT ===========");
                System.out.println("Payment Method: " + paymentMethod.getDisplayName());
                System.out.println("Transaction Reference: " + result.reference());
                System.out.println("Payment Status: "+ (result.successful() ? "SUCCESS" : "FAILED")
                );
                System.out.println("Message: " + result.message());

            } catch (RuntimeException e) {
                System.out.println(" Something went wrong while processing payment.");
                System.out.println("Please try again later.");
            }
        }
    }

}

