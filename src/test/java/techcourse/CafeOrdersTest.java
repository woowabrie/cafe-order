package techcourse;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CafeOrdersTest {

    @Nested
    class 총_가격_구하기_테스트 {
        @Test
        void 총_가격을_구할_수_있다() {
            final String[] items = items("라떼", "모카", "크로와상");
            final int[] quantities = quantities(1, 1, 1);

            final int result = CafeOrder.calculateTotalPrice(items, quantities);

            assertThat(result).isEqualTo(2000 + 2500 + 3000);
        }

        @Test
        void 한_메뉴를_여러개_시킬_수_있다() {
            final String[] items = items("라떼", "모카", "크로와상");
            final int[] quantities = quantities(2, 1, 1);

            final int result = CafeOrder.calculateTotalPrice(items, quantities);

            assertThat(result).isEqualTo(2000 * 2 + 2500 + 3000);
        }

        @Test
        void 한_메뉴를_여러번_시킬_수_있다() {
            final String[] items = items("라떼", "모카", "크로와상", "라떼");
            final int[] quantities = quantities(1, 1, 1, 1);

            final int result = CafeOrder.calculateTotalPrice(items, quantities);

            assertThat(result).isEqualTo(2000 + 2500 + 3000 + 2000);
        }

        @Test
        void 아메리카노는_개당_300원_할인된다() {
            final String[] items = items("아메리카노");
            final int[] quantities = quantities(2);

            final int result = CafeOrder.calculateTotalPrice(items, quantities);

            assertThat(result).isEqualTo((1500 - 300) * 2);
        }

        @Test
        void 음료가_5잔_이상이면_음료_전체_가격_10프로_할인된다() {
            final String[] items = items("라떼", "모카");
            final int[] quantities = quantities(3, 2);

            final int result = CafeOrder.calculateTotalPrice(items, quantities);

            assertThat(result).isEqualTo((int) ((2000 * 3 + 2500 * 2) * 0.9));
        }

        @Test
        void 아메리카노_할인이_음료5잔_할인이_같이_적용될_수_있다() {
            final String[] items = items("라떼", "아메리카노");
            final int[] quantities = quantities(3, 2);

            final int result = CafeOrder.calculateTotalPrice(items, quantities);

            assertThat(result).isEqualTo((int) (((2000 * 3 + 1500 * 2) * 0.9) - 300 * 2));
        }

        @Test
        void 존재하지_않는_메뉴라면_예외가_발생한다() {
            final String[] items = items("라떼", "모카", "크로와상", "쓰껄깍");
            final int[] quantities = quantities(1, 1, 1, 100);

            assertThatThrownBy(() -> CafeOrder.calculateTotalPrice(items, quantities))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {-1, 0})
        void 수량이_0_이하면_예외가_발생한다(final int invalidQuantity) {
            final String[] items = items("라떼", "모카");
            final int[] quantities = quantities(1, invalidQuantity);

            assertThatThrownBy(() -> CafeOrder.calculateTotalPrice(items, quantities))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    private static String[] items(String... itemNames) {
        return itemNames;
    }

    private static int[] quantities(int... quantities) {
        return quantities;
    }
}
