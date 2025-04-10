package techcourse.discount_policy;

public interface DiscountPolicy {

    int discountableAmount(final DiscountRequest request);
}
