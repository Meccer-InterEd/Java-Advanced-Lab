package org.example;




import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("ORD-1001", "Lerato", "249.99",OrderStatus.PLACED, PaymentStatus.PENDING, DeliveryMethod.COLLECTION);
        Order order2 = new Order("ORD-1002", "Nompumelelo", "249.99",OrderStatus.CONFIRMED, PaymentStatus.PAID, DeliveryMethod.STANDARD_DELIVERY);
        Order order3 = new Order("ORD-1003", "Precious", "249.99",OrderStatus.OUT_FOR_DELIVERY, PaymentStatus.PAID, DeliveryMethod.EXPRESS_DELIVERY);
        order1.displayStatus();
        VoucherPayment voucherPayment = new VoucherPayment(BigDecimal.valueOf(2000.99));
PaymentResult paymentResult = new PaymentResult(true, "VC-0024","Voucher payment successful");
CheckOutService checkOutService = new CheckOutService();
PaymentMethod card = new CardPayment(BigDecimal.valueOf());

checkOutService.checkout(card, new BigDecimal());




    }


}

