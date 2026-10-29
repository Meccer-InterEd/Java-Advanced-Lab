package org.example.BookingAndRecording;

public class Booking {
   //status enum
    public enum Status{
        REQUESTED,
        CONFIRMED,
        CANCELLED
    }

    //Booking class fields
   private String bookingID;
    private CustomerDetails customerDetails;
   private CourtBookingRequest bookingRequest;
   private Status status;

    Booking(){}

    Booking(String bookingID,CustomerDetails customerDetails,CourtBookingRequest bookingRequest, Status status){
        this.bookingID = bookingID;
        this.customerDetails = customerDetails;
        this.bookingRequest = bookingRequest;
        this.status = status;

    }

    public Status getStatus() {
        return status;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public CourtBookingRequest getBookingRequest() {
        return bookingRequest;
    }

    public String getBookingID() {
        return bookingID;
    }

    void confirmBooking(){
        if(this.status == Status.CANCELLED){
            System.out.println("Booking already " + Status.CANCELLED);
        }else{
            System.out.println("Booking status:  " + Status.CONFIRMED);
            this.status = Status.CONFIRMED;
        }
    }


    void cancelBooking(){
        if(this.status == Status.CANCELLED){
            System.out.println("Booking already " + Status.CANCELLED);
        }else{
            this.status = Status.CANCELLED;
            System.out.println("Booking status: " + Status.CANCELLED);
        }
    }
}
