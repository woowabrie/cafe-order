package techcourse;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderItemsTest {
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
    @DisplayName("주문 상품의 전체 가격을 계산한다.")
    void test() {
        // given
        OrderItems orderItems = OrderItems.of(items, new String[]{"크로와상", "라떼"}, new int[]{2, 2});

        // when
        int allPrices = orderItems.sumAllPrices();

        // then
        Assertions.assertThat(allPrices).isEqualTo(10000);
    }

    @Test
    @DisplayName("주문 상품의 개별 할인을 적용한 전체 가격을 계산한다.")
    void test2() {
        // given
        OrderItems orderItems = OrderItems.of(items, new String[]{"아메리카노", "라떼"}, new int[]{2, 2});

        // when
        int allPrices = orderItems.sumAllPrices();

        // then
        Assertions.assertThat(allPrices).isEqualTo(6400);
    }

    @Test
    @DisplayName("주문 상품의 음료 개수를 계산한다.")
    void test3() {
        // given
        OrderItems orderItems = OrderItems.of(items, new String[]{"아메리카노", "라떼", "크로와상"}, new int[]{2, 2, 2});

        // when
        int drinkCount = orderItems.drinkCount();

        // then
        Assertions.assertThat(drinkCount).isEqualTo(4);
    }

    @Test
    @DisplayName("주문 상품 중 음료 카테고리의 가격을 계산한다.")
    void test4() {
        // given
        OrderItems orderItems = OrderItems.of(items, new String[]{"아메리카노", "라떼", "크로와상"}, new int[]{2, 2, 2});

        // when
        int drinkPrices = orderItems.sumDrinkPrices();

        // then
        Assertions.assertThat(drinkPrices).isEqualTo(6400);
    }
}