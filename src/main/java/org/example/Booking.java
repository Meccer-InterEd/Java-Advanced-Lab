package org.example;

import com.sun.jdi.connect.Connector;

public class Booking {
    private String bookingID;
    private String fullName;
    private String bookingLocation;
    private BookingStatus bookingStatus;
    private CourtBookingRequest courtBookingRequest;

    public Booking(String bookingID, String fullName, String bookingLocation, BookingStatus bookingStatus, CourtBookingRequest courtBookingRequest) {
        setBookingID(bookingID);
        setFullName(fullName);
        setBookingLocation(bookingLocation);
        setBookingStatus(bookingStatus);
        setCourtBookingRequest(courtBookingRequest);
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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


    public boolean cancelBooking() {
        if (bookingStatus == BookingStatus.CANCELLED) {
            System.out.println("Booking status for booking ID: " + getBookingID() + " is already: " + getBookingStatus());
            return false;
        } else {
            this.bookingStatus = BookingStatus.CANCELLED;
            return true;
        }
    }

    public Boolean confirmBooking() {
        if (bookingStatus == BookingStatus.CONFIRMED) {
            System.out.println("Booking for booking ID: " + getBookingID() + " is already: " + getBookingStatus());
            return false;
        } else {
            this.bookingStatus = BookingStatus.CONFIRMED;
            System.out.println("Booking for booking ID: " + getBookingID() + " is now: " + getBookingStatus());
            return true;
        }
    }

}
