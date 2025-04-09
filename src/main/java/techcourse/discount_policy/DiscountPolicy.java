package techcourse.discount_policy;

import techcourse.cafe_order.CafeOrders;

public interface DiscountPolicy {

    int discountableAmount(final CafeOrders cafeOrders);
}
