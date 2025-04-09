package techcourse;

import java.util.Set;

public class CafeOrder {

    private static final Set<String> availableItemNames = Set.of("아메리카노", "라떼", "모카", "크로와상");

    public static int calculateTotalPrice(String[] items, int[] quantities) {
        final Order order = new Order(items, quantities)
                .filterItemNameNonExistIn(availableItemNames)
                .filterQuantityLowThan(1);

        items = order.items();
        quantities = order.quantities();

        int total = calculateDefaultTotalPrice(items, quantities);

        int drinkCount = getDrinkCount(items, quantities);
        total -= calculateDrinkDiscountablePrice(items, quantities, drinkCount, total);

        return total;
    }

    private static int calculateDefaultTotalPrice(final String[] items, final int[] quantities) {
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            int price = 0;
            if (items[i].equals("아메리카노")) {
                price = 1200;
            } else if (items[i].equals("라떼")) {
                price = 2000;
            } else if (items[i].equals("모카")) {
                price = 2500;
            } else if (items[i].equals("크로와상")) {
                price = 3000;
            }
            total += price * quantities[i];
        }
        return total;
    }

    private static int getDrinkCount(final String[] items, final int[] quantities) {
        int drinkCount = 0;
        for (int i = 0; i < items.length; i++) {
            if (!items[i].equals("크로와상")) {
                drinkCount += quantities[i];
            }
        }
        return drinkCount;
    }

    private static int calculateDrinkDiscountablePrice(final String[] items, final int[] quantities, final int drinkCount, int total) {
        if (drinkCount >= 5) {
            int drinkTotal = 0;
            for (int i = 0; i < items.length; i++) {
                if (!items[i].equals("크로와상")) {
                    int drinkPrice = 0;
                    if (items[i].equals("아메리카노")) {
                        drinkPrice = 1200;
                    } else if (items[i].equals("라떼")) {
                        drinkPrice = 2000;
                    } else if (items[i].equals("모카")) {
                        drinkPrice = 2500;
                    }
                    drinkTotal += drinkPrice * quantities[i];
                }
            }
            return drinkTotal / 10;
        }
        return 0;
    }
}
