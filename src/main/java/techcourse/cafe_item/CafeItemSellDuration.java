package techcourse.cafe_item;

import techcourse.sell_duration.SellDuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

public enum CafeItemSellDuration {
    별빛_프라페_5차_판매(CafeItem.별빛_프라페, new SellDuration(
            LocalDate.of(2025, 2, 15),
            LocalDate.of(2025, 6, 30)
    )),
    마인크래프트_케이크_1차_판매(CafeItem.마인크래프트_케이크, new SellDuration(
            LocalDate.of(2025, 5, 10),
            LocalDate.of(2025, 10, 25)
    )),
    ;

    private final CafeItem cafeItem;
    private final SellDuration sellDuration;

    CafeItemSellDuration(final CafeItem cafeItem, final SellDuration sellDuration) {
        this.cafeItem = cafeItem;
        this.sellDuration = sellDuration;
    }

    public static boolean isSellable(final CafeItem cafeItem, final LocalDateTime sellDateTime) {
        return Arrays.stream(values())
                .filter(value -> value.cafeItem == cafeItem)
                .map(value -> value.sellDuration.isBetween(sellDateTime))
                .findFirst()
                .orElse(true);
    }
}
