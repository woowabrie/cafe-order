package techcourse;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CafeOrder {

    private static final Set<DiscountPolicy> DISCOUNT_POLICIES = Set.of(
            new AmericanoDiscountPolicy(),
            new DrinkDiscountPolicy()
    );

    public static int calculateTotalPrice(final String[] items, final int[] quantities) {
        return calculateTotalPrice(Arrays.stream(items).toList(), Arrays.stream(quantities).boxed().toList());
    }

    private static int calculateTotalPrice(final List<String> items, final List<Integer> quantities) {
        final Orders orders = new Orders(items, quantities);
        final int total = orders.calculateTotalPrice();

        final int totalDiscountAmount = calculateTotalDiscountAmount(orders);

        return total - totalDiscountAmount;
    }

    private static int calculateTotalDiscountAmount(final Orders orders) {
        return DISCOUNT_POLICIES.stream()
                .mapToInt(policy -> policy.discountableAmount(orders))
                .sum();
    }
}
