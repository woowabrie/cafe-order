package techcourse;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ItemTest {
    @Test
    @DisplayName("음료수인지 판단한다.")
    void test() {
        // given
        Item item = new Item("음료수", 1600, 0, MenuCategory.DRINK);

        // when
        boolean isDrink = item.isDrink();

        // then
        Assertions.assertThat(isDrink).isTrue();
    }

    @Test
    @DisplayName("음료수가 아닌지 판단한다.")
    void test2() {
        // given
        Item item = new Item("디저트", 1600, 0, MenuCategory.DESERT);

        // when
        boolean isDrink = item.isDrink();

        // then
        Assertions.assertThat(isDrink).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"할인콜라,1600,100", "할인사이다,2000,500"})
    @DisplayName("상품의 개별 할인 가격을 반환한다")
    void test3(String expected) {
        // given
        String[] split = expected.split(",");
        String name = split[0];
        int price = Integer.parseInt(split[1]);
        int discount = Integer.parseInt(split[2]);

        Item item = new Item(name, price, discount, MenuCategory.DRINK);

        // when
        int priceApplyDiscount = item.getPriceApplyDiscount();

        // then
        Assertions.assertThat(priceApplyDiscount).isEqualTo(1500);
    }

    @Test
    @DisplayName("같은 이름인지 판단한다.")
    void test4() {
        // given
        Item item = new Item("음료수", 1600, 0, MenuCategory.DRINK);

        // when
        boolean isSameName = item.isSameName("음료수");

        // then
        Assertions.assertThat(isSameName).isTrue();
    }

    @Test
    @DisplayName("같은 이름이 아닌지 판단한다.")
    void test5() {
        // given
        Item item = new Item("디저트", 1600, 0, MenuCategory.DRINK);

        // when
        boolean isSameName = item.isSameName("음료수");

        // then
        Assertions.assertThat(isSameName).isFalse();
    }
}