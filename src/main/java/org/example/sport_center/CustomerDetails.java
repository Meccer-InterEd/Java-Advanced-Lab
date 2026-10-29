package org.example.sport_center;

public record CustomerDetails(
        String customerId,
        String fullName,
        String email,
        String phoneNumber
)

{
    public CustomerDetails{
        if(fullName == null || fullName.isBlank()){
            throw new IllegalArgumentException("Invalid Name");
        }

        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid Email");
        }

    }

}
