package org.example;

public record BookingSummary(Booking booking) {

    public void display() {
        System.out.println("-----------------Booking Summery---------------------------");


    }
}
