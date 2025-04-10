package techcourse.discount_policy;

import techcourse.cafe_item.CafeItem;

public class AmericanoDiscountPolicy implements DiscountPolicy {

    private static final int AMERICANO_DISCOUNT_AMOUNT = 300;

    @Override
    public int discountableAmount(final DiscountRequest request) {
        final int americanoCount = request.countOf(CafeItem.아메리카노);
        return americanoCount * AMERICANO_DISCOUNT_AMOUNT;
    }
}
