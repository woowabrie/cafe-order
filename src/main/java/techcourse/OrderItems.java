package techcourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderItems {

    private final List<OrderItem> orderItems;
    private final AmountPromotion amountPromotion;
    private final PercentPromotion percentPromotion;

    public OrderItems(List<OrderItem> orderItems) {
        final Map<Menu, Integer> discountMenus = new HashMap<>();
        discountMenus.put(Menu.AMERICANO, 300);
        this.orderItems = orderItems;
        this.amountPromotion = new AmountPromotion(discountMenus);
        this.percentPromotion = new PercentPromotion();
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
        totalPrice -= amountPromotion.calculateDiscountAmount(this, totalPrice);
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

    public int menuCount(Menu menu) {
        for (OrderItem orderItem : orderItems) {
            return orderItem.isAnyMenuCount(menu);
        }
        return 0;
    }
}
