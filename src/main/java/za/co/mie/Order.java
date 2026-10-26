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

    public OrderStatus status() {
        return status;
    }

    public PaymentStatus payment_status() {
        return payment_status;
    }

    public void mark_paid() {
        ensure_open();
        payment_status = PaymentStatus.PAID;
    }

    public void mark_payment_failed() {
        ensure_open();
        payment_status = PaymentStatus.FAILED;
    }

    public void confirm() {
        ensure_open();
        if (status != OrderStatus.PLACED) throw new IllegalStateException("Order already " + status);
        if (payment_status != PaymentStatus.PAID) throw new IllegalStateException("Payment is " + payment_status + ", cannot confirm");
        status = OrderStatus.CONFIRMED;
    }

    public OrderStatus next_status() {
        ensure_open();
        return status.next(delivery_method);
    }

    public void advance() {
        if (status == OrderStatus.PLACED) confirm();
        else status = next_status();
    }

    public void cancel() {
        ensure_open();
        if (!status.can_cancel()) throw new IllegalStateException("Order is " + status + ", cannot cancel");
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

    public String summary() {
        return order_number + " | " + customer_name + " | " + status + " | " + payment_status + " | " + delivery_method + " | total R" + total + " + fee R" + delivery_fee() + " = R" + grand_total();
    }

    private void ensure_open() {
        if (status.is_final()) throw new IllegalStateException("Order is " + status + " and cannot be changed");
    }
}