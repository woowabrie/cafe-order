package techcourse;

public class PercentPromotion {

    public static final int DISCOUNT_PERCENT = 10;

    public int calculateDiscountAmount(OrderItems orderItems, int price) {
        int drinkCount = orderItems.drinkCount();
        if (drinkCount >= 5) {
            return price / DISCOUNT_PERCENT;
        }
        return 0;
    }
}
