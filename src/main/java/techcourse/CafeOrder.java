package techcourse;

import java.util.Arrays;
import java.util.List;

public class CafeOrder {

    public static int calculateTotalPrice(final String[] items, final int[] quantities) {
        return calculateTotalPrice(Arrays.stream(items).toList(), Arrays.stream(quantities).boxed().toList());
    }

    private static int calculateTotalPrice(final List<String> items, final List<Integer> quantities) {
        final Orders orders = new Orders(items, quantities);
        int total = orders.calculateTotalPrice();
        total = discountDrinksIfPossible(orders, total);
        return total;
    }

    private static int discountDrinksIfPossible(final Orders orders, final int total) {
        int drinkCount = orders.countOf(CafeItemType.DRINK);
        if (drinkCount >= 5) {
            return total - orders.calculateTotalPriceOf(CafeItemType.DRINK) / 10;
        }
        return total;
    }
}
