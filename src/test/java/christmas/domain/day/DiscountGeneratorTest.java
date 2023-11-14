package christmas.domain.day;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountGeneratorTest {

    @DisplayName("할인 내용에 대한 정상 테스트")
    @ParameterizedTest
    @CsvSource(value = {"12, 크리스마스 디데이 할인 : -2100원/평일 할인 : -0원/",
                    "17, 크리스마스 디데이 할인 : -2600원/특별 할인 : -1000원/평일 할인 : -0원/",
                    "22, 크리스마스 디데이 할인 : -3100원/주말 할인 : -0원/",
                    "26, 평일 할인 : -0원/"})
    void discountContentTest(String input, String expected) {
        DiscountGenerator discountGenerator = new DiscountGenerator(input, 0, 0);
        assertThat(discountGenerator.getDiscountContent()).isEqualTo(expected);
    }

    @DisplayName("총 혜택금액에 대한 정상 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3, 2, 2, 6246"})
    void discountTotalDiscountTest(String inputDay, int main, int dessert, int expected) {
        DiscountGenerator discountGenerator = new DiscountGenerator(inputDay, main, dessert);
        assertThat(discountGenerator.getTotalDiscountSum()).isEqualTo(expected);
    }
}