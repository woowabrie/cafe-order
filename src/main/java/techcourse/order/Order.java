package techcourse.order;

import techcourse.cafe_item.CafeItemType;
import techcourse.cafe_item.CafeItems;

public class Order {

    private static final int MIN_QUANTITY = 1;

    private final CafeItems item;
    private final int quantity;

    public Order(final String itemName, final int quantity) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("최소 수량은 1개 입니다.");
        }
        this.item = CafeItems.valueOf(itemName);
        this.quantity = quantity;
    }

    public int calculatePrice() {
        return item.getPriceOf(quantity);
    }

    public boolean isTypeOf(final CafeItemType cafeItemType) {
        return item.isTypeOf(cafeItemType);
    }

    public boolean isTypeOf(final CafeItems cafeItem) {
        return item == cafeItem;
    }

    public int quantity() {
        return quantity;
    }
}
