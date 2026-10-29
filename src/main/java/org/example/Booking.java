package org.example;

public class Booking {
    private String bookingID;
    private String bookingLocation;
    private BookingStatus bookingStatus;
    private CourtBookingRequest courtBookingRequest;
    private CustomerDetails customerDetails;

    public Booking(String bookingID, String bookingLocation, BookingStatus bookingStatus, CourtBookingRequest courtBookingRequest, CustomerDetails customerDetails) {
        setBookingID(bookingID);
        setBookingLocation(bookingLocation);
        setBookingStatus(bookingStatus);
        setCourtBookingRequest(courtBookingRequest);
        setCustomerDetails(customerDetails);
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getBookingLocation() {
        return bookingLocation;
    }

    public void setBookingLocation(String bookingLocation) {
        this.bookingLocation = bookingLocation;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public CourtBookingRequest getCourtBookingRequest() {
        return courtBookingRequest;
    }

    public void setCourtBookingRequest(CourtBookingRequest courtBookingRequest) {
        this.courtBookingRequest = courtBookingRequest;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public void cancelBooking() {
        if (bookingStatus == BookingStatus.CANCELLED) {
            System.out.println("Booking status for booking ID: " + getBookingID() + " is already: " + getBookingStatus());
        } else {
            this.bookingStatus = BookingStatus.CANCELLED;
        }
    }

    public void confirmBooking() {
        if (bookingStatus == BookingStatus.CONFIRMED) {
            System.out.println("Booking for booking ID: " + getBookingID() + " is already: " + getBookingStatus());
        } else {
            this.bookingStatus = BookingStatus.CONFIRMED;
            System.out.println("Booking for booking ID: " + getBookingID() + " is now: " + getBookingStatus());
        }
    }

}
