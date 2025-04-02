import techcourse.Order;

public class Application {

    public static void main(String[] args) {
        String[] menus = {"아메리카노", "라떼"};
        int[] quantities = {5, 1};

        int orderPrice = Order.order(menus, quantities);
        System.out.println(orderPrice);
    }
}
