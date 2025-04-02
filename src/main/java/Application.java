import techcourse.Order;
import techcourse.Receipt;

public class Application {

    public static void main(String[] args) {
        String[] menus = {"아메리카노", "라떼"};
        int[] quantities = {5, 1};

        Receipt receipt = Order.order(menus, quantities);
        System.out.println(receipt.getPrice());
    }
}
