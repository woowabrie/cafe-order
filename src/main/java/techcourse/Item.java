package techcourse;

public class Item {
    private final String name;
    private final int price;
    private final int discountPrice;
    private final MenuCategory category;

    public Item(String name, int price, int discountPrice, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.category = category;
    }

    public boolean isDrink() {
        return this.category == MenuCategory.DRINK;
    }

    public int getPriceApplyDiscount() {
        return price - discountPrice;
    }

    public boolean isSameName(String item) {
        return this.name.equalsIgnoreCase(item);
    }
}
