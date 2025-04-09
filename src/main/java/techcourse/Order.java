package techcourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Order {

    private final List<CafeItems> items;
    private final List<Integer> quantities;

    public Order(final List<CafeItems> items, final List<Integer> quantities) {
        this.items = items;
        this.quantities = quantities;
    }

    public static Order withFilterNames(final String[] items, final int[] quantities, final Set<String> availableItemNames) {
        final List<CafeItems> cafeItems = Arrays.stream(items)
                .filter(availableItemNames::contains)
                .map(CafeItems::valueOf)
                .toList();

        return new Order(cafeItems, Arrays.stream(quantities).boxed().toList());
    }

    public Order filterQuantityLowThan(final int quantityThreshold) {
        final List<CafeItems> filteredItems = new ArrayList<>();
        final List<Integer> filteredQuantities = new ArrayList<>();

        for (int i = 0; i < items.size(); i++) {
            if (quantities.get(i) >= quantityThreshold) {
                filteredItems.add(items.get(i));
                filteredQuantities.add(quantities.get(i));
            }
        }

        return new Order(filteredItems, filteredQuantities);
    }

    public List<CafeItems> items() {
        return items;
    }

    public List<Integer> quantities() {
        return quantities;
    }
}
