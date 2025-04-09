package techcourse;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CafeOrder {

    private static final Set<DiscountPolicy> DEFAULT_DISCOUNT_POLICIES = Set.of(
            new AmericanoDiscountPolicy(),
            new DrinkDiscountPolicy()
    );

    private final Set<DiscountPolicy> discountPolicies;

    public CafeOrder(final Set<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
    }

    public CafeOrder() {
        this(DEFAULT_DISCOUNT_POLICIES);
    }

    public int calculateTotalPrice(final String[] items, final int[] quantities) {
        return calculateTotalPrice(Arrays.stream(items).toList(), Arrays.stream(quantities).boxed().toList());
    }

    private int calculateTotalPrice(final List<String> items, final List<Integer> quantities) {
        final Orders orders = new Orders(items, quantities);
        final int total = orders.calculateTotalPrice();

        final int totalDiscountAmount = calculateTotalDiscountAmount(orders);

        return total - totalDiscountAmount;
    }

    private int calculateTotalDiscountAmount(final Orders orders) {
        return discountPolicies.stream()
                .mapToInt(policy -> policy.discountableAmount(orders))
                .sum();
    }
}
