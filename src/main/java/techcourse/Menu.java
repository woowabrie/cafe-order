package techcourse;

public enum Menu {
    AMERICANO("아메리카노", 1500, 300, MenuCategory.DRINK),
    LATTE("라떼", 2000, 0, MenuCategory.DRINK),
    MOCHA("모카", 2500, 0, MenuCategory.DRINK),
    CROISSANT("크로와상", 3000, 0, MenuCategory.DESERT),
    ;

    private final String name;
    private final int price;
    private final int discountPrice;
    private final MenuCategory category;

    Menu(String name, int price, int discountPrice, MenuCategory category) {
        this.name = name;
        this.price = price;
        this.discountPrice = discountPrice;
        this.category = category;
    }

    public static Menu fromString(String item) {
        for (Menu value : values()) {
            if (item.equalsIgnoreCase(value.name)) {
                return value;
            }
        }
        throw new IllegalArgumentException("없는 메뉴입니다.");
    }

    public boolean isDrink() {
        return this.category == MenuCategory.DRINK;
    }

    public int getPrice() {
        return price - discountPrice;
    }
}
