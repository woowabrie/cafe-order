package techcourse;

public class Order {

    public static Receipt order(String[] items, int[] quantities) {
        OrderItems orderItems = OrderItems.of(items, quantities);
        return new Receipt(orderItems, orderItems.calculateTotalPrice());
    }
}
