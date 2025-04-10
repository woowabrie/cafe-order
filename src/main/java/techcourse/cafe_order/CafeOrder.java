package techcourse.cafe_order;

import techcourse.cafe_item.CafeItem;
import techcourse.cafe_item.CafeItemSellDuration;
import techcourse.cafe_item.CafeItemType;

import java.time.LocalDateTime;

public class CafeOrder {

    private static final int MIN_QUANTITY = 1;

    private final CafeItem item;
    private final int quantity;

    public CafeOrder(final String itemName, final int quantity, final LocalDateTime orderDateTime) {
        if (quantity < MIN_QUANTITY) {
            throw new IllegalArgumentException("최소 수량은 1개 입니다.");
        }
        final CafeItem item = CafeItem.findByName(itemName);
        if (!CafeItemSellDuration.isSellable(item, orderDateTime)) {
            throw new IllegalArgumentException("현재 판매중이지 않은 제품입니다.");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public int calculatePrice() {
        return item.getPriceOf(quantity);
    }

    public boolean isTypeOf(final CafeItemType cafeItemType) {
        return item.isTypeOf(cafeItemType);
    }

    public boolean isTypeOf(final CafeItem cafeItem) {
        return item == cafeItem;
    }

    public int quantity() {
        return quantity;
    }
}
