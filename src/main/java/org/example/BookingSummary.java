package org.example;

public record BookingSummary(Booking booking) {
    public void getSummary(){
        System.out.println("\n\n");
        System.out.println("=========Booking Summary=========");
        System.out.println("Booking Status: "+booking.getBookingStatus());
        if (booking.getBookingStatus().equals(BookingStatus.CONFIRMED)){
            System.out.println("Booking ID: "+booking.getBookingId());
            System.out.println("Court Number: "+booking.getBookingRequest().courtNumber());
            System.out.println("Booking Date: "+booking.getBookingRequest().bookingDate());
            System.out.println("Start Time: "+booking.getBookingRequest().startTime());
            System.out.println("Duration (in minutes): "+booking.getBookingRequest().durationMinutes());
        }
    }
}
