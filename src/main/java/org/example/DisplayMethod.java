package org.example;

import org.example.Lab02_Interface_Payment_System.*;
import org.example.Lab01_Enum_Food_Delivery_Order.DeliveryMethod;
import org.example.Lab01_Enum_Food_Delivery_Order.Order;
import org.example.Lab01_Enum_Food_Delivery_Order.PaymentStatus;
import org.example.Lap03_Records_BookingSystem.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

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
                System.out.println("Payment Status: " + (result.successful() ? "SUCCESS" : "FAILED")
                );
                System.out.println("Message: " + result.message());

            } catch (RuntimeException e) {
                System.out.println(" Something went wrong while processing payment.");
                System.out.println("Please try again later.");
            }
        }
    }

    public void DisplayBooking() {
        boolean running = true;

        while (running) {
            System.out.println("\n===== COURT BOOKING SYSTEM =====");
            System.out.println("1. Create new booking");
            System.out.println("2. Exit");
            System.out.print("Select your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> createNewBooking();
                case "2" -> {
                    running = false;
                    System.out.println("Thank you for using the Booking system.");
                }
                default -> System.out.println("Invalid option. Choose 1 or 2.");
            }
        }
    }

    private void createNewBooking() {
        String continueBooking;
        do {
            System.out.println("========= CREATE NEW BOOKING ==========");

            System.out.print("Enter full name: ");
            String fullName = scanner.nextLine().trim();

            System.out.print("Enter email: ");
            String email = scanner.nextLine().trim();

            System.out.print("Enter phone number: ");
            String phone = scanner.nextLine().trim();

            CustomerDetails bookingName = new CustomerDetails(fullName, email, phone);
            validateCoustomerDetails validCustomer = new validateCoustomerDetails();
            String customerResult = validCustomer.validate(bookingName);

            if (!customerResult.equals("VALID")) {
                System.out.println("ERROR OCCER: " + customerResult);
            }
            else {

                System.out.println("Customer details accepted.");

                System.out.print("Enter customer ID: ");
                String customerId = scanner.nextLine().trim();

                System.out.print("Enter court number: ");
                int courtNumber = readPositiveInteger();

                System.out.print("Enter booking duration in minutes: ");
                int duration = readPositiveInteger();

                CourtBookingRequest count = new CourtBookingRequest(
                        customerId,
                        courtNumber,
                        LocalDate.now(),
                        LocalTime.of(14, 0),
                        duration
                );

                validateCountBookingRequest req = new validateCountBookingRequest();

                String requestResult = req.validate(count);

                if (!requestResult.equals("VALID")) {
                    System.out.println("ERROR: " + requestResult);
                }
                else {

                    String bookingId = "BOOK-" + (1000 + (int)(Math.random() * 9000)); // simple random ID
                    Booking booking = new Booking(bookingId, BookingStatus.REQUESTED, count);

                    System.out.println("Booking ID: " + booking.getBookingId()
                    );

                    System.out.println("Initial status: " + booking.getStatus()
                    );
                    System.out.println(booking.ConfirmingBooking());

                    System.out.println("Current status: " + booking.getStatus()
                    );

                    BookingSummary summary = new BookingSummary(
                            booking.getBookingId(),
                            bookingName.fullName(),
                            count.countNumber(),
                            count.bookingDate(),
                            count.startTime(),
                            count.durationMinutes(),
                            booking.getStatus()
                    );

                    System.out.println("\n===== DAILY BOOKING SUMMARY =====");
                    System.out.println("Booking ID: " + summary.bookingId());
                    System.out.println("Customer: " + summary.customerName());
                    System.out.println("Court: " + summary.courtNumber());
                    System.out.println("Date: " + summary.bookingDate());
                    System.out.println("Start time: " + summary.startTime());
                    System.out.println(
                            "Duration: " + summary.durationMinutes() + " minutes"
                    );
                    System.out.println("Status: " + summary.status());
                }
            }

            System.out.print("\nCreate another booking? (y/n): ");
            continueBooking = scanner.nextLine().trim();

        } while (continueBooking.equalsIgnoreCase("y"));

        System.out.println("Booking process finished.");
    }
    private int readPositiveInteger() {

        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int number = Integer.parseInt(input);

                if (number > 0) {
                    return number;
                }
                System.out.print("Enter a number greater than zero: ");

            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Enter a whole number: ");
            }
        }
    }
}