package techcourse;

public class OrderItem {
    private final Item item;
    private final int quantity;

    private OrderItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public static OrderItem of(Item item, int quantity) {
        return new OrderItem(item, quantity);
    }

    public int totalPrice() {
        return item.getPriceApplyDiscount() * quantity;
    }

    public int drinkCount() {
        if (item.isDrink()) {
            return quantity;
        }
        return 0;
    }

    public boolean isDrink() {
        return item.isDrink();
    }
}
