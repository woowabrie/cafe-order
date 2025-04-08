package techcourse;

public class Order {
    private final OrderItems orderItems;

    public Order(OrderItems orderItems) {
        this.orderItems = orderItems;
    }

    public int calculateTotalPrice() {
        return orderItems.calculateTotalPrice();
    }
}
