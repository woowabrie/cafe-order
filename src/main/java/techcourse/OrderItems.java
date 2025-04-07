package techcourse;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {

    private static final int DEFAULT_DRINK_DISCOUNT_COUNT = 5;
    private static int DEFAULT_DISCOUNT_PERCENT = 10;

    private final List<OrderItem> orderItems;

    public OrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static OrderItems of(String[] items, int[] quantities) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            orderItems.add(OrderItem.of(items[i], quantities[i]));
        }
        return new OrderItems(orderItems);
    }

    public int calculateTotalPrice() {
        int totalPrice = calculatePriceBeforeApplyPromotion();
        if (drinkCount() >= DEFAULT_DRINK_DISCOUNT_COUNT) {
            totalPrice -= totalPrice / DEFAULT_DISCOUNT_PERCENT;
        }
        return totalPrice;
    }

    private int calculatePriceBeforeApplyPromotion() {
        return orderItems.stream()
                .mapToInt(OrderItem::totalPrice)
                .sum();
    }

    public int drinkCount() {
        return orderItems.stream()
                .mapToInt(OrderItem::drinkCount)
                .sum();
    }
}
