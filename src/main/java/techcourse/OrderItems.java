package techcourse;

import java.util.ArrayList;
import java.util.List;

public class OrderItems {
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

    public int sumAllPrices() {
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
