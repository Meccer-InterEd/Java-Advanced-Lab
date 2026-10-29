package org.example;

public record CustomerDetails(String fullName, String email, String phoneNumber) {
    public CustomerDetails{
        try {
            if (fullName == null || fullName.isBlank()){
                AlertService.inputValidationAlerts("\nCustomer's full names must be provided!!!");
            } else if (email == null || email.isBlank()){
                AlertService.inputValidationAlerts("\nCustomer's email must be provided!!!");
            } else if (phoneNumber == null || phoneNumber.isBlank()){
                AlertService.inputValidationAlerts("\nCustomer's phone number must be provided!!!");
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
