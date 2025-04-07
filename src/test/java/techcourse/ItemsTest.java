package techcourse;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ItemsTest {
    @Test
    @DisplayName("이름으로 상품을 찾는다")
    void test() {
        // given
        Item item1 = new Item("아메리카노", 1500, 300, MenuCategory.DRINK);
        Items items = new Items(List.of(item1));

        // when
        Item item = items.itemFrom("아메리카노");

        // then
        Assertions.assertThat(item).isEqualTo(item1);
    }

    @Test
    @DisplayName("없는 상품이면 예외를 반환한다")
    void test2() {
        // given
        Items items = new Items(List.of());

        // when & then
        Assertions.assertThatThrownBy(() -> items.itemFrom("아메리카노"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("없는 메뉴입니다.");
    }
}