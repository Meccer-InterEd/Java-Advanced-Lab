package org.example;

class AccountService {

    String user;

    @RequiresRole("ADMIN")
    public void deleteUser(String userId) {
        if ("ADMIN".equals(user)) {
            System.out.println("Deleting user");
        } else {
            System.out.println("User not authorised");
        }

    }

    @RequiresRole("MANAGER")
    public void approveExpense(double amount) {
        if ("MANAGER".equals(user)) {
            System.out.println("Approving expense");
        } else {
            System.out.println("User not authorised");
        }
    }

    public void viewProfile() {
        System.out.println("Viewing profile");
    }
}

