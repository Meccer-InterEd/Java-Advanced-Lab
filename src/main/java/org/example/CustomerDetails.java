package org.example;

public record CustomerDetails(
        String fullName,
        String email,
        String phoneNumber) {


   public CustomerDetails {
      if(fullName == null || fullName.isBlank()){
         throw new IllegalArgumentException(
                 "Full Name can not be blank"
        );
      }

    if (phoneNumber == null || phoneNumber.isBlank()){
        throw new IllegalArgumentException(
                "Phone Number can not be blank"
        );
    }
    if(email == null || email.matches("\\b[A-Z0-9._%-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b")){
        throw new IllegalArgumentException(
                "Email can not be black and must contain @"
        );
    }
   }
}
