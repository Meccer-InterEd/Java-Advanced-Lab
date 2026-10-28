package org.example;

public record CustomerDetails(String fullName, String email , String phoneNumber) {
    public CustomerDetails{
        if(fullName.equals(null)){
            throw new IllegalArgumentException("Full name can not be blank.");
        }
        if(phoneNumber.equals(null)){
            throw new IllegalArgumentException("Phone number can not be blank");
        }
        if(!email.contains("@")){
            throw new IllegalArgumentException("Email must have an @ symbol");
        }
    }
}
