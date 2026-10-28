package org.example.Lap03_Records_BookingSystem;

public class validateCoustomerDetails {

    public String validate(CustomerDetails customer) {
        if (customer == null) {
            return "Customer details are required";
        }
        if (customer.fullName() == null||customer.fullName().isBlank()) {
            return "Customer cannot be bank";
        }
        if (customer.email() == null ||!customer.email().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$")) {
            return "Please enter the valid email address.";
        }
        if (customer.phoneNumber() == null || customer.phoneNumber().isBlank()) {
            return "Phone number cannot be empty.";
        }
        return "enter  vaild details";
    }
}
