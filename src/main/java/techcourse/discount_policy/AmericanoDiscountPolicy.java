package techcourse.discount_policy;

import techcourse.cafe_item.CafeItem;
import techcourse.cafe_order.CafeOrders;

public class AmericanoDiscountPolicy implements DiscountPolicy {

    private static final int AMERICANO_DISCOUNT_AMOUNT = 300;

    @Override
    public int discountableAmount(final CafeOrders cafeOrders) {
        final int americanoCount = cafeOrders.countOf(CafeItem.아메리카노);
        return americanoCount * AMERICANO_DISCOUNT_AMOUNT;
    }
}
