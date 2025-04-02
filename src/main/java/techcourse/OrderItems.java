package techcourse;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {

    private final List<OrderItem> orderItems;
    private final PercentPromotion percentPromotion;

    public OrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
        this.percentPromotion = new PercentPromotion(PercentPromotion.DEFAULT_DISCOUNT_PERCENT);
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
        totalPrice -= percentPromotion.calculateDiscountAmount(this, totalPrice);
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
