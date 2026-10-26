package org.example;

import org.example.Lab1.DeliveryMethod;
import org.example.Lab1.Order;

public class Main {
    public static void main(String[] args) {

        Order order = new Order(
                1001,
                "Lerato",
                249.99,
                DeliveryMethod.STANDARD_DELIVERY
        );
        }
    }
