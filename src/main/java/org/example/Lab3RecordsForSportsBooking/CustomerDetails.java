package org.example.Lab3RecordsForSportsBooking;

public record CustomerDetails(String fullName, String email, String phoneNumber) {

    public CustomerDetails {
            if(fullName == null || fullName.isBlank()){
                throw new RuntimeException("Error, You have left the name field empty");
            }

            if(email == null || email.isBlank()){
                throw new RuntimeException("Error, you have left the email field empty");
            }
            if(!email.contains("@")|| !email.contains(".")){
                throw new RuntimeException("Error, invalid email format");
            }

            if(phoneNumber == null || phoneNumber.isBlank()){
                throw new RuntimeException("Error, you have left the phone number field empty ");
            }

            if(phoneNumber.length() <10){
                throw new RuntimeException("Error, Phone number should be 10 numbers long");
            }
    }
}
