package techcourse.cafe_order;

import techcourse.cafe_item.CafeItem;
import techcourse.cafe_item.CafeItemType;

import java.util.List;
import java.util.stream.IntStream;

public class CafeOrders {

    private final List<CafeOrder> cafeOrders;

    public CafeOrders(final List<String> items, final List<Integer> quantities) {
        if (items.size() != quantities.size()) {
            throw new IllegalArgumentException("아이템과 수량의 개수가 다릅니다.");
        }
        this.cafeOrders = IntStream.range(0, items.size())
                .mapToObj(i -> new CafeOrder(items.get(i), quantities.get(i)))
                .toList();
    }

    public int calculateTotalPrice() {
        return cafeOrders.stream()
                .mapToInt(CafeOrder::calculatePrice)
                .sum();
    }

    public int countOf(final CafeItemType cafeItemType) {
        return cafeOrders.stream()
                .filter(cafeOrder -> cafeOrder.isTypeOf(cafeItemType))
                .mapToInt(CafeOrder::quantity)
                .sum();
    }

    public int countOf(final CafeItem cafeItem) {
        return cafeOrders.stream()
                .filter(cafeOrder -> cafeOrder.isTypeOf(cafeItem))
                .mapToInt(CafeOrder::quantity)
                .sum();
    }

    public int calculateTotalPriceOf(final CafeItemType cafeItemType) {
        return cafeOrders.stream()
                .filter(cafeOrder -> cafeOrder.isTypeOf(cafeItemType))
                .mapToInt(CafeOrder::calculatePrice)
                .sum();
    }
}
