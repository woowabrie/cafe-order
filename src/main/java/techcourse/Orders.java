package techcourse;

import java.util.List;
import java.util.stream.IntStream;

public class Orders {

    private final List<Order> orders;

    public Orders(final List<String> items, final List<Integer> quantities) {
        if (items.size() != quantities.size()) {
            throw new IllegalArgumentException("아이템과 수량의 개수가 다릅니다.");
        }
        this.orders = IntStream.range(0, items.size())
                .mapToObj(i -> new Order(items.get(i), quantities.get(i)))
                .toList();
    }

    public int calculateTotalPrice() {
        return orders.stream()
                .mapToInt(Order::calculatePrice)
                .sum();
    }

    public int countOf(final CafeItemType cafeItemType) {
        return orders.stream()
                .filter(order -> order.isTypeOf(cafeItemType))
                .mapToInt(Order::quantity)
                .sum();
    }

    public int calculateTotalPriceOf(final CafeItemType cafeItemType) {
        return orders.stream()
                .filter(order -> order.isTypeOf(cafeItemType))
                .mapToInt(Order::calculatePrice)
                .sum();
    }
}
