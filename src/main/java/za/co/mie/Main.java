package za.co.mie;

public class Main {
    public static void main(String[] args) {
        System.out.println("Do good and be productive!!");

        // LAB 1
        Order order = new Order("ORD-1001", "Lerato", Money.of("249.99"), DeliveryMethod.STANDARD_DELIVERY);
        order.display_results();
//        try {
//            order.confirm();
//        } catch (RuntimeException e) {
//            System.out.println("Rejected: " + e.getMessage());
//        }
        attempt(order::confirm);
        order.mark_paid();
        order.advance(3);
        order.display_results();
        attempt(order::cancel);
        attempt(() -> new Order("ORD-1002", "Sipho", Money.of("-5"), DeliveryMethod.COLLECTION));
    }

    static void attempt(Runnable action){
        try {
            action.run();
        } catch (RuntimeException exception){
            System.out.println("Rejected: " + exception.getMessage());
        }
    }
}
