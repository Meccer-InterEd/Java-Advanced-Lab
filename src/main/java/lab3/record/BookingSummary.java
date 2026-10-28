package lab3.record;

import lab3.record.classes.Booking;

public record BookingSummary(CustomerDetails customer , CourtBookingRequest courtBookingRequest , Booking.BookingStatus status , String bookingId) {



}
