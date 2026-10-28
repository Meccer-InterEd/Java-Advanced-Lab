package org.example;

public record CustomerDetails(String fullName, String email, String phoneNumber) {

    public CustomerDetails{
        if(fullName.isBlank() || fullName == null){
            throw new IllegalArgumentException("Provide your name!!");
        }

        if(email == null ){
            throw new IllegalArgumentException("Provide a valid email");
        }
    }
}
