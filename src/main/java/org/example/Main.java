package org.example;




import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 7.");
            }
        }

        scanner.close();
    }
}

