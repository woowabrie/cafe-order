package techcourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public record Order(String[] items, int[] quantities) {

    public Order filterQuantityLowThan(final int quantityThreshold) {
        final List<String> filteredItems = new ArrayList<>();
        final List<Integer> filteredQuantities = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            if (quantities[i] >= quantityThreshold) {
                filteredItems.add(items[i]);
                filteredQuantities.add(quantities[i]);
            }
        }
        return new Order(
                filteredItems.toArray(new String[0]),
                filteredQuantities.stream().mapToInt(Integer::intValue).toArray()
        );
    }

    public Order filterItemNameNonExistIn(final Set<String> availableItemNames) {
        final List<String> filteredItems = new ArrayList<>();
        final List<Integer> filteredQuantities = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            if (availableItemNames.contains(items[i])) {
                filteredItems.add(items[i]);
                filteredQuantities.add(quantities[i]);
            }
        }

        return new Order(
                filteredItems.toArray(new String[0]),
                filteredQuantities.stream().mapToInt(Integer::intValue).toArray()
        );
    }
}
