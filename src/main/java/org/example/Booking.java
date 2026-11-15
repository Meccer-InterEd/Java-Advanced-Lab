package org.example;

public class Booking {
    private String bookingId;
    private CourtBookingRequest request;
    private BookingStatus status = BookingStatus.REQUESTED;
    private CustomerDetails details;

    public Booking(String bookingId, CustomerDetails details, CourtBookingRequest request){

        setBookingId(bookingId);
        this.details = details;
        this.request = request;
    }


    public CustomerDetails getDetails(){return details;}
    public String getBookingId(){ return bookingId;}
    public CourtBookingRequest getRequest() {return request;}

    public BookingStatus getStatus(){return status;}

    public void setBookingId(String bookingId){
        this.bookingId = bookingId;
    }

   public void confirmedBooking(){
        if (status == BookingStatus.CANCELLED){
            System.out.println("A cancelled booking can not be confirmed");
        } else {
            status = BookingStatus.CONFIRMED;
            System.out.println("Your booking has been confirmed");
        }
    }

    public void canceledBooking(){
       status = BookingStatus.CANCELLED;
        System.out.println("Your booking has been cancelled");
    }







}
