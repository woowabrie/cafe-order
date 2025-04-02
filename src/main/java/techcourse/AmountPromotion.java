package techcourse;

import java.util.Map;
import java.util.Map.Entry;

public class AmountPromotion {

    private final Map<Menu, Integer> discountMenus;

    public AmountPromotion(Map<Menu, Integer> discountMenus) {
        this.discountMenus = discountMenus;
    }

    public int calculateDiscountAmount(OrderItems orderItems, int price) {
        int discountAmount = 0;
        for (Entry<Menu, Integer> discountMenu : discountMenus.entrySet()) {
            discountAmount += orderItems.menuCount(discountMenu.getKey()) * discountMenu.getValue();
        }
        return discountAmount;
    }
}
