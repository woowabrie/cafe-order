package techcourse;

public class Order {
    private static final int DEFAULT_DRINK_DISCOUNT_COUNT = 5;
    private static final int DEFAULT_DISCOUNT_PERCENT = 10;

    private final OrderItems orderItems;

    public Order(OrderItems orderItems) {
        this.orderItems = orderItems;
    }

    public int calculateTotalPrice() {
        int totalPrice = orderItems.sumAllPrices();
        if (orderItems.drinkCount() >= DEFAULT_DRINK_DISCOUNT_COUNT) {
            totalPrice -= totalPrice / DEFAULT_DISCOUNT_PERCENT;
        }
        return totalPrice;
    }
}
