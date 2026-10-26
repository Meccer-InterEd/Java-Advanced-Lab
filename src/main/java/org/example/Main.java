package org.example;


//import jdk.swing.interop.SwingInterOpUtils;

import org.example.Lab1FoodDeliveryOrder.DeliveryMethod;
import org.example.Lab1FoodDeliveryOrder.Order;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Order order = new Order("Ord-111", "Thabang", new BigDecimal(250.00), DeliveryMethod.STANDARD_DELIVERY);
        order.confirmPayment(BigDecimal.valueOf(250.00));
        }

    }
