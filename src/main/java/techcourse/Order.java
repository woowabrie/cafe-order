package techcourse;

public class Order {

    private final CafeItems item;
    private final int quantity;

    public Order(final String itemName, final int quantity) {
        if (quantity < 1) {
            throw new IllegalArgumentException("최소 수량은 1개 입니다.");
        }
        this.item = CafeItems.valueOf(itemName);
        this.quantity = quantity;
    }

    public int calculatePrice() {
        return item.getPriceOf(quantity);
    }

    public boolean isTypeOf(final CafeItemType cafeItemType) {
        return item.isTypeOf(cafeItemType);
    }

    public int quantity() {
        return quantity;
    }
}
