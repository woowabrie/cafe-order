package techcourse;

public class OrderItem {

    private final Menu menu;
    private final int quantity;

    private OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public static OrderItem of(String menuName, int quantity) {
        Menu menu = Menu.fromString(menuName);
        return new OrderItem(menu, quantity);
    }

    public int totalPrice() {
        return menu.getPrice() * quantity;
    }

    public int drinkCount() {
        if (menu.isDrink()) {
            return quantity;
        }
        return 0;
    }

    public int isAnyMenuCount(Menu menu) {
        if (this.menu == menu) {
            return this.quantity;
        }
        return 0;
    }
}
