package techcourse.discount_policy;

import techcourse.cafe_item.CafeItemType;
import techcourse.cafe_order.CafeOrders;

public class DrinkDiscountPolicy implements DiscountPolicy {

    private static final int DRINK_DISCOUNT_COUNT_THRESHOLD = 5;
    private static final double DRINK_DISCOUNT_RATIO = 0.1;

    @Override
    public int discountableAmount(final CafeOrders cafeOrders) {
        final int drinkCount = cafeOrders.countOf(CafeItemType.DRINK);
        if (drinkCount < DRINK_DISCOUNT_COUNT_THRESHOLD) {
            return 0;
        }
        final int totalPriceOfDrink = cafeOrders.calculateTotalPriceOf(CafeItemType.DRINK);
        return (int) (totalPriceOfDrink * DRINK_DISCOUNT_RATIO);
    }
}
