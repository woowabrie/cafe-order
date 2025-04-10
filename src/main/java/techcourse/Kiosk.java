package techcourse;

import techcourse.cafe_order.CafeOrders;
import techcourse.discount_policy.AmericanoDiscountPolicy;
import techcourse.discount_policy.DiscountPolicy;
import techcourse.discount_policy.DiscountRequest;
import techcourse.discount_policy.DrinkDiscountPolicy;

import java.time.LocalDateTime;
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

    public int calculateTotalPrice(final String[] items, final int[] quantities, final LocalDateTime orderDateTime) {
        return calculateTotalPrice(Arrays.stream(items).toList(), Arrays.stream(quantities).boxed().toList(), orderDateTime);
    }

    private int calculateTotalPrice(final List<String> items, final List<Integer> quantities, final LocalDateTime orderDateTime) {
        final CafeOrders cafeOrders = new CafeOrders(items, quantities, orderDateTime);
        final int total = cafeOrders.calculateTotalPrice();

        final int totalDiscountAmount = calculateTotalDiscountAmount(cafeOrders, orderDateTime);

        return total - totalDiscountAmount;
    }

    private int calculateTotalDiscountAmount(final CafeOrders cafeOrders, final LocalDateTime orderDateTime) {
        final DiscountRequest request = new DiscountRequest(cafeOrders, orderDateTime);
        return discountPolicies.stream()
                .mapToInt(policy -> policy.discountableAmount(request))
                .sum();
    }
}
