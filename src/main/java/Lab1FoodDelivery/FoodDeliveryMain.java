package Lab1FoodDelivery;

public class FoodDeliveryMain {
    public static void Main (String[] args) {
        Order order = new Order(1001, "Lerato", 249.99, DeliveryMethod.EXPRESS_DELIVERY);
        order.display();
        order.paymentStatus(PaymentStatus.PAID);
        order.confirmOrder();
//        order.cancelOrder();
        order.display();
        order.nextStatus();
        order.display();
        order.nextStatus();
        order.display();
        order.nextStatus();
        order.display();
        order.nextStatus();
        order.display();
    }
}
