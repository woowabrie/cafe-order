package techcourse.cafe_item;

public enum CafeItem {
    아메리카노(1500, CafeItemType.DRINK),
    라떼(2000, CafeItemType.DRINK),
    모카(2500, CafeItemType.DRINK),
    크로와상(3000, CafeItemType.BREAD),
    ;

    private final int price;
    private final CafeItemType type;

    CafeItem(final int price, final CafeItemType type) {
        this.price = price;
        this.type = type;
    }

    public int getPriceOf(final int quantity) {
        return price * quantity;
    }

    public boolean isTypeOf(final CafeItemType cafeItemType) {
        return type == cafeItemType;
    }
}
