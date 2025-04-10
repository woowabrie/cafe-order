package techcourse.discount_policy;

import techcourse.cafe_item.CafeItemType;

public class DrinkDiscountPolicy implements DiscountPolicy {

    private static final int DRINK_DISCOUNT_COUNT_THRESHOLD = 5;
    private static final double DRINK_DISCOUNT_RATIO = 0.1;

    @Override
    public int discountableAmount(final DiscountRequest request) {
        final int drinkCount = request.countOf(CafeItemType.DRINK);
        if (drinkCount < DRINK_DISCOUNT_COUNT_THRESHOLD) {
            return 0;
        }
        final int totalPriceOfDrink = request.totalPriceOf(CafeItemType.DRINK);
        return (int) (totalPriceOfDrink * DRINK_DISCOUNT_RATIO);
    }
}
