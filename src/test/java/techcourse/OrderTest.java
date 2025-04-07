package techcourse;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    private Items items;

    @BeforeEach
    void setUp() {
        items = new Items(List.of(
                new Item("아메리카노", 1500, 300, MenuCategory.DRINK),
                new Item("라떼", 2000, 0, MenuCategory.DRINK),
                new Item("모카", 2500, 0, MenuCategory.DRINK),
                new Item("크로와상", 3000, 0, MenuCategory.DESERT)
        ));
    }

    @Test
    @DisplayName("주문한 상품의 가격을 계산한다")
    void test() {
        // given
        Order order = createOrder(new String[]{"라떼", "모카", "크로와상"}, new int[]{1, 1, 1});

        // when
        int totalPrice = order.calculateTotalPrice();

        // then
        Assertions.assertThat(totalPrice).isEqualTo(7500);
    }

    @Test
    @DisplayName("주문한 상품의 대형 손님 환영 프로모션을 적용한 가격을 계산한다")
    void test2() {
        // given
        Order order = createOrder(new String[]{"라떼", "모카"}, new int[]{2, 3});

        // when
        int totalPrice = order.calculateTotalPrice();

        // then
        Assertions.assertThat(totalPrice).isEqualTo(10350);
    }

    @Test
    @DisplayName("주문한 상품의 대형 손님 환영 프로모션을 적용한 가격을 계산한다")
    void test3() {
        // given
        Order order = createOrder(new String[]{"라떼", "모카"}, new int[]{2, 3});

        // when
        int totalPrice = order.calculateTotalPrice();

        // then
        Assertions.assertThat(totalPrice).isEqualTo(10350);
    }

    private Order createOrder(String[] names, int[] quantities) {
        return new Order(OrderItems.of(items, names, quantities));
    }
}