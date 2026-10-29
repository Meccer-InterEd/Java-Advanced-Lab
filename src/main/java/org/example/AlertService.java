package org.example;

public class AlertService {
    public static void inputValidationAlerts(String message) throws InterruptedException {
        System.out.println(message);
        System.out.println("\nProgram will now terminate itself...");
        Thread.sleep(4000);
        System.exit(0);
    }
}
