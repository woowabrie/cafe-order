package techcourse;

public class PercentPromotion implements Promotion {

    public static final int DISCOUNT_PERCENT = 10;

    @Override
    public int calculateDiscountAmount(OrderItems orderItems, int price) {
        int drinkCount = orderItems.drinkCount();
        if (drinkCount >= 5) {
            return price / DISCOUNT_PERCENT;
        }
        return 0;
    }
}
