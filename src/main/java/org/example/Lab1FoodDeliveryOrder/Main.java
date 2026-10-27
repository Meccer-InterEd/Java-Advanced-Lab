package org.example.Lab1FoodDeliveryOrder;

import java.math.BigDecimal;


public class Main {
    public static void main(String[] args){
      Order order = new Order("ORD-1001", "Thabang", new BigDecimal(250.00), DeliveryMethod.STANDARD_DELIVERY);
         order.display();
          order.confirmPayment(new BigDecimal("300.00"));
          order.nextStatus();
          order.nextStatus();
          order.nextStatus();
         
          System.out.println("\n Final State");
          order.display();

    Order order2 = new Order("ORD-1002","Keitu",new BigDecimal("150.00"),DeliveryMethod.COLLECTION);
        order2.display();
        order2.confirmPayment(new BigDecimal("100.00"));
        order2.nextStatus();

        Order order3 = new Order("ORD-1003","Heisham",new BigDecimal("550.00"),DeliveryMethod.EXPRESS_DELIVERY);
        order3.display();
        order3.confirmPayment(new BigDecimal("650.00"));
        order3.nextStatus();
        order3.nextStatus();
        order3.cancelOrder();

    }
}
