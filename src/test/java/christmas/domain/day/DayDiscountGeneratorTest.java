package christmas.domain.day;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DayDiscountGeneratorTest {

    @DisplayName("할인 내용에 대한 정상 테스트")
    @ParameterizedTest
    @CsvSource(value = {"12, 크리스마스 디데이 할인 : -0원/평일 할인 : -0원/",
                    "17, 크리스마스 디데이 할인 : -0원/특별 할인 : -0원/평일 할인 : -0원/",
                    "22, 크리스마스 디데이 할인 : -0원/주말 할인 : -0원/",
                    "26, 평일 할인 : -0원/"})
    void discountDayTest(String input, String expected) {
        DiscountGenerator discountGenerator = new DiscountGenerator(input);
        assertThat(discountGenerator.getDiscountContent()).isEqualTo(expected);
    }
}