package org.example.Lab1FoodDeliveryOrder;

import java.math.BigDecimal;

import static org.example.Lab1FoodDeliveryOrder.DeliveryMethod.COLLECTION;

public class Main {
    public static void main(String[] args){
        Order o1 = new Order("1","mo",new BigDecimal(788),COLLECTION);

        o1.display();

    }
}
