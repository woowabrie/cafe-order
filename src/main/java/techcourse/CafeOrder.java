package techcourse;

public class CafeOrder {

    public static int calculateTotalPrice(String[] items, int[] quantities) {
        final Order order = new Order(items, quantities)
                .filterItemNameNonExistIn(CafeItems.names())
                .filterQuantityLowThan(1);

        CafeItems[] cafeItems = order.cafeItems();
        quantities = order.quantities();

        int total = calculateDefaultTotalPrice(cafeItems, quantities);

        int drinkCount = getDrinkCount(cafeItems, quantities);
        total -= calculateDrinkDiscountablePrice(cafeItems, quantities, drinkCount);

        return total;
    }
    
    private static int calculateDefaultTotalPrice(final CafeItems[] items, final int[] quantities) {
        int total = 0;
        for (int i = 0; i < items.length; i++) {
            total += items[i].getPriceOf(quantities[i]);
        }
        return total;
    }

    private static int getDrinkCount(final CafeItems[] items, final int[] quantities) {
        int drinkCount = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].isDrink()) {
                drinkCount += quantities[i];
            }
        }
        return drinkCount;
    }

    private static int calculateDrinkDiscountablePrice(final CafeItems[] items, final int[] quantities, final int drinkCount) {
        if (drinkCount >= 5) {
            int drinkTotal = 0;
            for (int i = 0; i < items.length; i++) {
                if (items[i].isDrink()) {
                    drinkTotal += items[i].getPriceOf(quantities[i]);
                }
            }
            return drinkTotal / 10;
        }
        return 0;
    }
}
