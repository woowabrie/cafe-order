package techcourse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemTest {
    @Test
    @DisplayName("주문 상품의 총 가격을 계산한다.")
    void test() {
        // given
        OrderItem orderItem = OrderItem.of(new Item("아이템", 1500, 0, MenuCategory.DRINK), 5);

        // when
        int totalPrice = orderItem.totalPrice();

        // then
        Assertions.assertThat(totalPrice).isEqualTo(7500);
    }

    @Test
    @DisplayName("주문 상품의 음료 개수를 계산한다.")
    void test2() {
        // given
        OrderItem orderItem = OrderItem.of(new Item("아이템", 1500, 0, MenuCategory.DRINK), 5);

        // when
        int drinkCount = orderItem.drinkCount();

        // then
        Assertions.assertThat(drinkCount).isEqualTo(5);
    }

    @Test
    @DisplayName("주문 상품이 음료인지 아닌지 판단한다.")
    void test3() {
        // given
        OrderItem orderItem = OrderItem.of(new Item("아이템", 1500, 0, MenuCategory.DRINK), 5);

        // when
        boolean isDrink = orderItem.isDrink();

        // then
        Assertions.assertThat(isDrink).isTrue();
    }
}