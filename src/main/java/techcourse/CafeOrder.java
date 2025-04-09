package techcourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CafeOrder {

    private static final Set<String> availableItemNames = Set.of("아메리카노", "라떼", "모카", "크로와상");

    public static int calculateTotalPrice(String[] items, int[] quantities) {

        final List<String> filteredItems = new ArrayList<>();
        final List<Integer> filteredQuantities = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            if (availableItemNames.contains(items[i]) && quantities[i] > 0) {
                filteredItems.add(items[i]);
                filteredQuantities.add(quantities[i]);
            }
        }
        items = filteredItems.toArray(new String[0]);
        quantities = filteredQuantities.stream().mapToInt(Integer::intValue).toArray();

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

        int drinkCount = 0;
        for (int i = 0; i < items.length; i++) {
            if (!items[i].equals("크로와상")) {
                drinkCount += quantities[i];
            }
        }

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
            total -= drinkTotal / 10;
        }

        return total;
    }
}
