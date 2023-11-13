package christmas.domain.day;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class DayGenerateTest {

    @DisplayName("할인 내용에 대한 정상 테스트")
    @ParameterizedTest
    @CsvSource(value = {"12, 크리스마스 할인/주중 할인/",
                    "17, 크리스마스 할인/특별 할인/주중 할인/",
                    "22, 크리스마스 할인/주말 할인/",
                    "26, 주중 할인/"})
    void discountDayTest(String input, String expected) {
        DayGenerate dayGenerate = new DayGenerate(input);
        assertThat(dayGenerate.getDiscountContent()).isEqualTo(expected);
    }
}