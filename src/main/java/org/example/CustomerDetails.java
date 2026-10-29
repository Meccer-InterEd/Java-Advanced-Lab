package org.example;

public record CustomerDetails(String fullName, String email, String phoneNumber) {

    public CustomerDetails {
        if (fullName.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }

        if (!email.contains("@")){
            throw new IllegalArgumentException("Invalid email format");
        }

        if (phoneNumber.isBlank()) {
            throw new IllegalArgumentException("Phone number cannot be blank");
        }

        if (phoneNumber.length() < 10 || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("Phone number ust be 10 digits long");
        }
    }
}
