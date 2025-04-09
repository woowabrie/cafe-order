package techcourse.discount_policy;

import techcourse.cafe_item.CafeItems;
import techcourse.order.Orders;

public class AmericanoDiscountPolicy implements DiscountPolicy {

    private static final int AMERICANO_DISCOUNT_AMOUNT = 300;

    @Override
    public int discountableAmount(final Orders orders) {
        final int americanoCount = orders.countOf(CafeItems.아메리카노);
        return americanoCount * AMERICANO_DISCOUNT_AMOUNT;
    }
}
