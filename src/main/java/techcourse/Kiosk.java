package techcourse;

import techcourse.cafe_order.CafeOrders;
import techcourse.discount_policy.AmericanoDiscountPolicy;
import techcourse.discount_policy.DiscountPolicy;
import techcourse.discount_policy.DrinkDiscountPolicy;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Kiosk {

    private static final Set<DiscountPolicy> DEFAULT_DISCOUNT_POLICIES = Set.of(
            new AmericanoDiscountPolicy(),
            new DrinkDiscountPolicy()
    );

    private final Set<DiscountPolicy> discountPolicies;

    public Kiosk(final Set<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public Kiosk() {
        this(DEFAULT_DISCOUNT_POLICIES);
    }

    public int calculateTotalPrice(final String[] items, final int[] quantities) {
        return calculateTotalPrice(Arrays.stream(items).toList(), Arrays.stream(quantities).boxed().toList());
    }

    private int calculateTotalPrice(final List<String> items, final List<Integer> quantities) {
        final CafeOrders cafeOrders = new CafeOrders(items, quantities);
        final int total = cafeOrders.calculateTotalPrice();

        final int totalDiscountAmount = calculateTotalDiscountAmount(cafeOrders);

        return total - totalDiscountAmount;
    }

    private int calculateTotalDiscountAmount(final CafeOrders cafeOrders) {
        return discountPolicies.stream()
                .mapToInt(policy -> policy.discountableAmount(cafeOrders))
                .sum();
    }
}
