package techcourse;

import java.util.List;

public class CafeOrder {

    public static int calculateTotalPrice(String[] items, int[] quantities) {
        final Order order = Order.withFilterNames(items, quantities, CafeItems.names())
                .filterQuantityLowThan(1);

        final List<CafeItems> cafeItems = order.items();
        final List<Integer> itemQuantities = order.quantities();

        int total = calculateDefaultTotalPrice(cafeItems, itemQuantities);

        int drinkCount = getDrinkCount(cafeItems, itemQuantities);
        total -= calculateDrinkDiscountablePrice(cafeItems, itemQuantities, drinkCount);

        return total;
    }

    private static int calculateDefaultTotalPrice(final List<CafeItems> items, final List<Integer> quantities) {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getPriceOf(quantities.get(i));
        }
        return total;
    }

    private static int getDrinkCount(final List<CafeItems> items, final List<Integer> quantities) {
        int drinkCount = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isDrink()) {
                drinkCount += quantities.get(i);
            }
        }
        return drinkCount;
    }

    private static int calculateDrinkDiscountablePrice(final List<CafeItems> items, final List<Integer> quantities, final int drinkCount) {
        if (drinkCount >= 5) {
            int drinkTotal = 0;
            for (int i = 0; i < items.size(); i++) {
                if (items.get(i).isDrink()) {
                    drinkTotal += items.get(i).getPriceOf(quantities.get(i));
                }
            }
            return drinkTotal / 10;
        }
        return 0;
    }
}
