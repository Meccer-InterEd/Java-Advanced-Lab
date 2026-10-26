package Lab_1;


public class Order {
    private String orderNumber;
    private String CustomerName;
    private double totalAmount;

    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    private DeliveryMethod deliveryMethod;

    public Order (String orderNumber, String CustomerName,
                  double totalAmount, DeliveryMethod deliveryMethod) {

        this.orderNumber = orderNumber;
        this.CustomerName = CustomerName;
        this.deliveryMethod = deliveryMethod;
        this.totalAmount = totalAmount;

        orderStatus = OrderStatus.PLACED;
        paymentStatus = PaymentStatus.PENDING;
    }
    public void details() {
            System.out.println(orderNumber);
            System.out.println(CustomerName);
            System.out.println(totalAmount);
            System.out.println(orderStatus);
            System.out.println(paymentStatus);
        }



    }




