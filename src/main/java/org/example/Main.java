package org.example;




import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
   DisplayMethod menu = new DisplayMethod();
        boolean running = true;

        while (running) {

            // display the menu
            System.out.println("=========== Real-World Programming  ===========");
            System.out.println("1. Lab01 Food Delivery Order");
            System.out.println("2. Lab02 Payment System");
            System.out.println("3. Lab03 Records for Booking and Reporting");
            System.out.println("4. Lab04 Custom Annotations for Business Rules");
            System.out.println("5. Lab05 Vehicle Rental");
            System.out.println("6. Lab05 Employee Payroll");
            System.out.println("7. Lab06 Strategy Pattern in a Delivery App");
            System.out.println("8. Lab07 Clinic Booking System");
            System.out.println("9. Lab08 Community Event Booking Platform");
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
                    menu.DisplayFoodDelivery();
                    break;
                case 2:
//                    System.out.println("Comming Soon");
                    menu.DisplayPayment();

                    break;
                case 3:
                    menu.DisplayBooking();

                    break;
                case 4:
                    System.out.println("Comming Soon");
                    break;
                case 5:
                    System.out.println("Comming Soon");
                    break;
                case 6:
                    System.out.println("Comming Soon");
                    break;
                case 7:
                    System.out.println("Comming Soon");
                    break;
                case 8:
                    running = false;

                    System.out.println("You went back to the  Real-World Programming System .");

                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 7.");
            }
        }

        scanner.close();
    }
}

