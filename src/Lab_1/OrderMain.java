package Lab_1;

import java.math.BigDecimal;

public class OrderMain {

    public void main () {

        Order order1 = new Order(
                "ORD-1001",
                "Lerato",
                new BigDecimal ("249.99"),
                DeliveryMethod.STANDARD_DELIVERY
        );


        order1.pay();
        order1.confirmDetails();

        order1.details();


    }

}
