package lab.enums;

import lab.enums.classes.Order;
import lab.enums.classes.exception.MyException;

public class main {

    public static void main(String[] args) throws MyException {

        Order order1 = new Order(1,500,"Solomon", DeliveryMethod.STANDARD_DELIVERY);

        order1.setPaymentStatus(PaymentStatus.PAID);

        order1.nextStatus();

        order1.display();

        order1.setDelivery(DeliveryMethod.COLLECTION);

    }
}
