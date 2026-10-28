package org.example;

public record CustomerDetails(String fullName, String email, String phoneNumber)
{

    public CustomerDetails{

        if(fullName.isBlank() || !email.contains("@")){

            throw new IllegalArgumentException("Name cannot be blank and the email is invalid! email format 'mgdhsa@gmail.com'");
        }
        if(!phoneNumber.matches("\\d+")){

            throw new IllegalArgumentException("A phone number can only be digits");
        }
    }
}