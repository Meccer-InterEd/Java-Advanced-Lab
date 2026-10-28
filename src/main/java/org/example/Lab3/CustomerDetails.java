package org.example.Lab3;

public record CustomerDetails(
        String fullName,
        String email,
        String phoneNumber
) {
    public CustomerDetails {
        if (fullName == null || fullName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank.");
        }

        if (email == null || email.isBlank() || !email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid email address.");
        }

        if (phoneNumber == null || phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be blank.");
        }
    }
}

