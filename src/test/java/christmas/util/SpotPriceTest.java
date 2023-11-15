package christmas.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class SpotPriceTest {

    @DisplayName("가격을 문자열로 변환하는 정상 테스트")
    @ParameterizedTest
    @CsvSource(value = {
            "12345:12,345",
            "10023452:10,023,452"},
            delimiter = ':')
    void addPriceSpotTest(int price, String spotPrice) {
        assertThat(SpotPrice.addPriceSpot(price)).isEqualTo(spotPrice);
    }
}