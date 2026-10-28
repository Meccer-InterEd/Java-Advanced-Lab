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
        paymentStatus = PaymentStatus.PAID;
    }

    public void confirmDetails() {
        if (paymentStatus == PaymentStatus.PAID) {
            orderStatus = OrderStatus.CONFIRMED;
        } else {
            System.out.println("Payment needs to be made");

        }
    }
      public void PrepareDetails() {

        if (orderStatus == OrderStatus.CONFIRMED) {
            orderStatus = OrderStatus.PREPARING;
        }
        else {
            System.out.println("Order must be confirmed");
        }
    }

        public void Collection() {
              if (orderStatus == OrderStatus.PREPARING) {
                  orderStatus = OrderStatus.READY_FOR_COLLECTION;
              }
          }

          if (orderStatus == OrderStatus.READY_FOR_COLLECTION &&
           deliveryMethod == DeliveryMethod.COLLECTION){
           orderStatus = OrderStatus.DELIVERED;
    }
 else if (orderStatus == OrderStatus.READY_FOR_COLLECTION &&
      deliveryMethod == DeliveryMethod.STANDARD_DELIVERY)
      orderStatus = OrderStatus.OUT_FOR_DELIVERY)


    public void details() {
        System.out.println(orderNumber);
        System.out.println(CustomerName);
        System.out.println(totalAmount);
        System.out.println(orderStatus);
        System.out.println(paymentStatus);
        System.out.println(deliveryMethod);
    }
}