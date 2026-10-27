package Lab_1;


import java.math.BigDecimal;

public class Order {
    private String orderNumber;
    private String CustomerName;
    private BigDecimal totalAmount;

    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;


    public Order(String orderNumber, String CustomerName,
                 BigDecimal totalAmount, DeliveryMethod deliveryMethod) {

        this.orderNumber = orderNumber;
        this.CustomerName = CustomerName;
        this.deliveryMethod = deliveryMethod;
        this.totalAmount = totalAmount;

        orderStatus = OrderStatus.PLACED;
        paymentStatus = PaymentStatus.PENDING;

    }

    public void pay() {
        paymentStatus = PaymentStatus.FAILED;
    }

    public void confirmDetails() {
        if (paymentStatus == PaymentStatus.PAID) {
            orderStatus = OrderStatus.CONFIRMED;
        } else {
            System.out.println("Payment needs to be made");

        }
    }

    public void details() {
        System.out.println(orderNumber);
        System.out.println(CustomerName);
        System.out.println(totalAmount);
        System.out.println(orderStatus);
        System.out.println(paymentStatus);
        System.out.println(deliveryMethod);
    }
}