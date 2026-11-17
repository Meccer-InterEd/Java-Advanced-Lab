package org.example;

public class CustomerAccountService {

    @Audited(reason = "Tracking contact updates for customers")
    public void updateContactDetails() {
        System.out.println("Contact details updated successfully");
    }

    @Audited(reason = "Tracking the closing of account")
    public void closeAccount() {
        System.out.println("Account Closed");
    }

    public void viewAccount() {
        System.out.println("Viewing Account");
    }
}
