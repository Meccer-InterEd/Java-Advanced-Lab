package org.example;

public record CustomerDetails(String fullName, String email, String phoneNumber) {
    public CustomerDetails{
        if  (fullName.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        if   (email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be empty");
        }
        if  (phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be empty");
        }
    }
}
