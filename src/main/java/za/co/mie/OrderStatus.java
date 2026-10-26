package za.co.mie;

public enum OrderStatus {
    PLACED, CONFIRMED, PREPARING, READY_FOR_COLLECTION, OUT_FOR_DELIVERY, DELIVERED, CANCELLED;

    public OrderStatus next(DeliveryMethod method) {
        return switch (this) {
            case PLACED -> CONFIRMED;
            case CONFIRMED -> PREPARING;
            case PREPARING -> method == DeliveryMethod.COLLECTION ? READY_FOR_COLLECTION : OUT_FOR_DELIVERY;
            case READY_FOR_COLLECTION, OUT_FOR_DELIVERY -> DELIVERED;
            case DELIVERED, CANCELLED -> throw new IllegalStateException(this + " order cannot change");
        };
    }

    public boolean can_cancel() {
        return switch (this) {
            case PLACED, CONFIRMED, PREPARING, READY_FOR_COLLECTION -> true;
            default -> false;
        };
    }

    public boolean is_final() {
        return this == DELIVERED || this == CANCELLED;
    }
}
