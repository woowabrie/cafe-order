package techcourse;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {
    private static final int DEFAULT_DRINK_DISCOUNT_COUNT = 5;
    private static final int DEFAULT_DISCOUNT_PERCENT = 10;

    private final List<OrderItem> orderItems;

    private OrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public static OrderItems of(Items items, String[] orderItemNames, int[] orderQuantities) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (int i = 0; i < orderItemNames.length; i++) {
            Item item = items.itemFrom(orderItemNames[i]);
            orderItems.add(OrderItem.of(item, orderQuantities[i]));
        }
        return new OrderItems(orderItems);
    }

    public int calculateTotalPrice() {
        int totalPrice = sumAllPrices();
        if (couldApplyPromotion()) {
            totalPrice -= sumDrinkPrices() / DEFAULT_DISCOUNT_PERCENT;
        }
        return totalPrice;
    }

    private int sumAllPrices() {
        return orderItems.stream()
                .mapToInt(OrderItem::totalPrice)
                .sum();
    }

    private boolean couldApplyPromotion() {
        return drinkCount() >= DEFAULT_DRINK_DISCOUNT_COUNT;
    }

    private int sumDrinkPrices() {
        return orderItems.stream()
                .filter(OrderItem::isDrink)
                .mapToInt(OrderItem::totalPrice)
                .sum();
    }

    private int drinkCount() {
        return orderItems.stream()
                .mapToInt(OrderItem::drinkCount)
                .sum();
    }
}
