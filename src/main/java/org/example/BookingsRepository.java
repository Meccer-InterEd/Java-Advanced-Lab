package org.example;

import java.util.ArrayList;

public class BookingsRepository {
    private static ArrayList<Booking> database = new ArrayList<>();
    private static boolean isADuplicate;

    public static boolean foundDuplicateBooking(Booking booking){
        for(Booking _booking : database){
            isADuplicate = BookingsRepository.checkDuplicate(_booking, booking);
            if (isADuplicate){
                System.out.println("\nFailed to confirm booking because the desired slot is already taken!!! Please place a new " +
                        "booking with a different slot.");
                break;
            }
        }
        return isADuplicate;
    }

    public static void removeBooking(Booking booking){
        database.remove(booking);
    }

    public static void addBooking(Booking booking){
        if(!isADuplicate){
            database.add(booking);
        }
    }

    private static boolean checkDuplicate(Booking existing_booking, Booking new_booking){

        return existing_booking.getBookingRequest().courtNumber() == new_booking.getBookingRequest().courtNumber()
                && existing_booking.getBookingRequest().bookingDate().equals(new_booking.getBookingRequest().bookingDate())
                && existing_booking.getBookingRequest().startTime().equals(new_booking.getBookingRequest().startTime());
    }
}
