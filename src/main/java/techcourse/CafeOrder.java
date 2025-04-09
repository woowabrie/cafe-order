package techcourse;

public class CafeOrder {

    public static int calculateTotalPrice(String[] items, int[] quantities) {
        final Order order = new Order(items, quantities)
                .filterItemNameNonExistIn(CafeItems.names())
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
            total += CafeItems.getPriceOf(items[i], quantities[i]);
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
                    drinkTotal += CafeItems.getPriceOf(items[i], quantities[i]);
                }
            }
            return drinkTotal / 10;
        }
        return 0;
    }
}
