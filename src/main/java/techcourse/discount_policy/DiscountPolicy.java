package techcourse.discount_policy;

import techcourse.order.Orders;

public interface DiscountPolicy {

    int discountableAmount(final Orders orders);
}
