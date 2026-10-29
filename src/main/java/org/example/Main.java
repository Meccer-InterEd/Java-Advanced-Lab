
package org.example;
import java.time.LocalDate;
import java.time.LocalTime;
import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Order order1 = new Order(
                "ORD-1001", "Lerato", "249.99",
                OrderStatus.PLACED,
                PaymentStatus.PENDING,
                DeliveryMethod.COLLECTION
        );

        Order order2 = new Order(
                "ORD-1002", "Nompumelelo", "249.99",
                OrderStatus.PLACED,
                PaymentStatus.PENDING,
                DeliveryMethod.STANDARD_DELIVERY
        );

        Order order3 = new Order(
                "ORD-1003", "Precious", "249.99",
                OrderStatus.PLACED,
                PaymentStatus.PENDING,
                DeliveryMethod.EXPRESS_DELIVERY
        );

        CheckOutService checkout = new CheckOutService();

        CardPayment card =
                new CardPayment(new BigDecimal("500.00"));

        VoucherPayment voucher =
                new VoucherPayment(new BigDecimal("100.00"));

        InstantEftPayment eft = new InstantEftPayment();

        BigDecimal total1 = order1.getTotamt()
                .add(order1.deliveryPrice());

        BigDecimal total2 = order2.getTotamt()
                .add(order2.deliveryPrice());

        BigDecimal total3 = order3.getTotamt()
                .add(order3.deliveryPrice());

        System.out.println("\n===== ORDER 1 =====");
        order1.displayCustomer();
        PaymentResult result1 = checkout.checkout(card, total1);
        if (result1.successful()) {
            order1.makePayment(card);
        }


        System.out.println("\n===== ORDER 2 =====");
        order2.displayCustomer();
        PaymentResult result2 = checkout.checkout(voucher, total2);
        if (result2.successful()) {
            order2.makePayment(voucher);
        }


        System.out.println("\n===== ORDER 3 =====");
        order3.displayCustomer();
        PaymentResult result3 = checkout.checkout(eft, total3);
        if (result3.successful()) {
            order3.makePayment(eft);
        }
        System.out.println("=================end of lab====================");

        CustomerDetails customerDetails = new CustomerDetails("John Dube", "lucky428@redemption.com","0712233344");
        CourtBookingRequest request = new CourtBookingRequest("123456g", 5, LocalDate.of(2026,11,2),LocalTime.of(11,50), 50);
Booking booking = new Booking("12456",request,BookingStatus.CANCELLED);
booking.confirm();
booking.confirm();
booking.displayBooking();

    }
}
