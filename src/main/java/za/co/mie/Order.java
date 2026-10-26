package za.co.mie;

import java.math.BigDecimal;

public class Order {
    private final String order_number;
    private final String customer_name;
    private final BigDecimal total;
    private final DeliveryMethod delivery_method;
    private OrderStatus status = OrderStatus.PLACED;
    private PaymentStatus payment_status = PaymentStatus.PENDING;

    public Order(String order_number, String customer_name, BigDecimal total, DeliveryMethod delivery_method) {
        if (order_number == null || order_number.isBlank()) throw new IllegalArgumentException("Order number must not be blank");
        if (customer_name == null || customer_name.isBlank()) throw new IllegalArgumentException("Customer name must not be blank");
        if (total == null || total.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Order total must not be negative");
        if (delivery_method == null) throw new IllegalArgumentException("Delivery method is required");
        this.order_number = order_number.trim();
        this.customer_name = customer_name.trim();
        this.total = total;
        this.delivery_method = delivery_method;
    }

    public void mark_paid() {
        check_open();
        payment_status = PaymentStatus.PAID;
    }

    public void confirm() {
        check_open();
        if (status != OrderStatus.PLACED) throw new IllegalStateException("Order already " + status);
        if (payment_status != PaymentStatus.PAID) throw new IllegalStateException("Payment is " + payment_status + ", cannot confirm");
        status = OrderStatus.CONFIRMED;
    }

    public OrderStatus next_status() {
        check_open();
        return switch (status) {
            case PLACED -> OrderStatus.CONFIRMED;
            case CONFIRMED -> OrderStatus.PREPARING;
            case PREPARING -> delivery_method == DeliveryMethod.COLLECTION ? OrderStatus.READY_FOR_COLLECTION : OrderStatus.OUT_FOR_DELIVERY;
            default -> OrderStatus.DELIVERED;
        };
    }

    public void advance() {
        if (status == OrderStatus.PLACED) confirm();
        else status = next_status();
    }

    public void advance(int steps) {
        for (int i = 0; i < steps; i++) advance();
    }

    public void cancel() {
        check_open();
        if (status == OrderStatus.OUT_FOR_DELIVERY) throw new IllegalStateException("Order already dispatched, cannot cancel");
        status = OrderStatus.CANCELLED;
        payment_status = payment_status == PaymentStatus.PAID ? PaymentStatus.REFUNDED : payment_status;
    }

    public BigDecimal delivery_fee() {
        return switch (delivery_method) {
            case COLLECTION -> new BigDecimal("0.00");
            case STANDARD_DELIVERY -> new BigDecimal("35.00");
            case EXPRESS_DELIVERY -> new BigDecimal("65.00");
        };
    }

    public BigDecimal grand_total() {
        return total.add(delivery_fee());
    }

    public void display_results() {
        System.out.println("Order " + order_number + " | " + customer_name + " | " + status + " | payment " + payment_status + " | " + delivery_method + " | total R" + total + " + fee R" + delivery_fee() + " = R" + grand_total());
    }

    private void check_open() {
        if (status == OrderStatus.DELIVERED || status == OrderStatus.CANCELLED) throw new IllegalStateException("Order is " + status + " and cannot be changed");
    }
}
