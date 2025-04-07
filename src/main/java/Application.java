import java.util.List;
import techcourse.Item;
import techcourse.Items;
import techcourse.MenuCategory;
import techcourse.Order;
import techcourse.OrderItems;

public class Application {
    public static void main(String[] args) {
        String[] menus = {"아메리카노", "라떼"};
        int[] quantities = {5, 1};
        Items items = new Items(List.of(
                new Item("아메리카노", 1500, 300, MenuCategory.DRINK),
                new Item("라떼", 2000, 0, MenuCategory.DRINK),
                new Item("모카", 2500, 0, MenuCategory.DRINK),
                new Item("크로와상", 3000, 0, MenuCategory.DESERT)
        ));
        Order order = new Order(OrderItems.of(items, menus, quantities));

        int orderPrice = order.calculateTotalPrice();
        System.out.println(orderPrice);
    }
}
