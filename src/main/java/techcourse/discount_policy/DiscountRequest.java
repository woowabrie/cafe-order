package techcourse.discount_policy;

import techcourse.cafe_item.CafeItem;
import techcourse.cafe_item.CafeItemType;
import techcourse.cafe_order.CafeOrders;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Arrays;

public record DiscountRequest(
        CafeOrders cafeOrders,
        LocalDateTime orderDateTime
) {
    public boolean isIn(final DayOfWeek... dayOfWeeks) {
        return Arrays.stream(dayOfWeeks)
                .anyMatch(dayOfWeek -> dayOfWeek == orderDateTime.getDayOfWeek());
    }

    public int countOf(final CafeItem cafeItem) {
        return cafeOrders.countOf(cafeItem);
    }

    public int countOf(final CafeItemType cafeItemType) {
        return cafeOrders.countOf(cafeItemType);
    }

    public int totalPriceOf(final CafeItemType cafeItemType) {
        return cafeOrders.calculateTotalPriceOf(cafeItemType);
    }
}
