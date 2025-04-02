package techcourse;

public class Receipt {
    private final OrderItems orderItems;
    private final int price;

    public Receipt(OrderItems orderItems, int price) {
        this.orderItems = orderItems;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
