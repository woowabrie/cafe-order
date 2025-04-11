package techcourse.cafe_item;

import java.time.LocalDateTime;
import java.util.Arrays;

public enum CafeItem {
    아메리카노(1500, CafeItemType.DRINK),
    라떼(2000, CafeItemType.DRINK),
    모카(2500, CafeItemType.DRINK),
    크로와상(3000, CafeItemType.BREAD),
    별빛_프라페(7000, CafeItemType.DRINK),
    마인크래프트_케이크(8500, CafeItemType.BREAD),
    ;

    private final int price;
    private final CafeItemType type;

    CafeItem(final int price, final CafeItemType type) {
        this.price = price;
        this.type = type;
    }

    public static CafeItem findByName(final String findName) {
        return Arrays.stream(values())
                .filter(value -> getFormattedName(value).equals(findName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 메뉴입니다."));
    }

    private static String getFormattedName(final CafeItem value) {
        return value.name().replaceAll("_", " ");
    }

    public boolean isSellable(final LocalDateTime sellDateTime) {
        return CafeItemSellDuration.isSellable(this, sellDateTime);
    }

    public int getPriceOf(final int quantity) {
        return price * quantity;
    }

    public boolean isTypeOf(final CafeItemType cafeItemType) {
        return type == cafeItemType;
    }
}
