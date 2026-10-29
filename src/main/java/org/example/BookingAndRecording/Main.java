package org.example.BookingAndRecording;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args){



        Booking firstBooking = new Booking("111123",
                                    new CustomerDetails("Thamsanqa","tahmiix@gmail.com","0815216277"),
                                    new CourtBookingRequest("123",1, LocalDate.of(2026,10,2), LocalTime.of(14,30),40)
                                    , Booking.Status.REQUESTED);

        ArrayList<Booking> bookings = new ArrayList<>();
        ArrayList<BookingSummary> bookingSummaryList = new ArrayList<>();
        bookings.add(firstBooking);


        firstBooking.confirmBooking();
        firstBooking.cancelBooking();
        firstBooking.confirmBooking();

        for(Booking b : bookings){
            int cNum = b.getBookingRequest().courtNumber();

        }





    }
}
