package techcourse;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public enum CafeItems {
    아메리카노(1200),
    라떼(2000),
    모카(2500),
    크로와상(3000),
    ;

    private final int price;

    CafeItems(final int price) {
        this.price = price;
    }

    public static int getPriceOf(final String itemName, final int quantity) {
        return CafeItems.valueOf(itemName).price * quantity;
    }

    public static Set<String> names() {
        return Arrays.stream(CafeItems.values())
                .map(Enum::name)
                .collect(Collectors.toSet());
    }
}
