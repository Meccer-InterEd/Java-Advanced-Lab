package org.example.FoodDeliveryOrder;

public class Main {
    public static void main(String[] args){
Order order = new Order();
        Order o = new Order("Thamsanqa",11111,250,DeliveryMethod.STANDARD_DELIVERY);

        order.confirmOrder(300,o);
        order.moveStatus(o);

    }
}
