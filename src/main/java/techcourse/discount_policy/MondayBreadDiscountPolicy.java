package techcourse.discount_policy;

import techcourse.cafe_item.CafeItemType;

import java.time.DayOfWeek;

public class MondayBreadDiscountPolicy implements DiscountPolicy {

    private static final double BREAD_DISCOUNT_RATIO = 0.3;

    @Override
    public int discountableAmount(final DiscountRequest request) {
        if (!request.isIn(DayOfWeek.MONDAY)) {
            return 0;
        }
        final int totalPriceOfBread = request.totalPriceOf(CafeItemType.BREAD);
        return (int) (totalPriceOfBread * BREAD_DISCOUNT_RATIO);
    }
}
