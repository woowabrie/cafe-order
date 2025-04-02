package techcourse;

public class Order {

    public static int order(String[] items, int[] quantities) {

        OrderItems orderItems = OrderItems.of(items, quantities);
        return orderItems.calculateTotalPrice();
    }
}
