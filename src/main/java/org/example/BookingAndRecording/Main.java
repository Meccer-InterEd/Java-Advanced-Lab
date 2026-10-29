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
            LocalDate date = b.getBookingRequest().bookingDate();
            LocalTime time = b.getBookingRequest().startTime();
            CustomerDetails cDetails = b.getCustomerDetails();

            bookingSummaryList.add(new BookingSummary(cNum,date,time,cDetails));

        }

        for(BookingSummary bs : bookingSummaryList){
            System.out.println("Court Number:" + bs.courtNumber() +
                                "\nDate: " + bs.date() +
                                "\nTime: " + bs.time() +
                                "\nCustomer Details :" + bs.customerDetails().fullName() + " | " + bs.customerDetails().email() + " | " + bs.customerDetails().phoneNumber());
        }



    }
}
