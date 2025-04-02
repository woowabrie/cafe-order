package techcourse;

public class PercentPromotion {

    public static final int DEFAULT_DRINK_DISCOUNT_COUNT = 5;
    public static int DEFAULT_DISCOUNT_PERCENT = 10;

    public final int discountPercent;

    public PercentPromotion(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int calculateDiscountAmount(OrderItems orderItems, int price) {
        int drinkCount = orderItems.drinkCount();
        if (drinkCount >= DEFAULT_DRINK_DISCOUNT_COUNT) {
            return price / discountPercent;
        }
        return 0;
    }
}
