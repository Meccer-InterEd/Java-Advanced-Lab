package org.example.BookingAndRecording;

public record CustomerDetails(String fullName, String email, String phoneNumber) {
  public  CustomerDetails{
        if(fullName == null || fullName.equalsIgnoreCase("")){
            throw new IllegalArgumentException("Cannot accept empty name");
        }

        if(!email.contains("@")){
            throw new IllegalArgumentException("email does not contain @");
        }
    }
}
