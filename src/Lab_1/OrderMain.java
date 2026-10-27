package Lab_1;

public class OrderMain {

    public void main () {

        Order order1 = new Order(
                "ORD-1001",
                "Lerato",
                249.99,
                DeliveryMethod.STANDARD_DELIVERY
        );


        order1.pay();
        order1.confirmDetails();

        order1.details();


    }

}
