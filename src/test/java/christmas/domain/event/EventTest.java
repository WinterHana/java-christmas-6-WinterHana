package christmas.domain.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {
    @DisplayName("증정 이벤트에 대한 정상 테스트")
    @Test
    void giftEvenTest() {
        Event event = new GiftEvent(120000);
        assertThat(event.eventInfo()).isEqualTo("샴페인 1개");
    }

    @DisplayName("뱃지 이벤트에 대한 정상 테스트")
    @ParameterizedTest
    @CsvSource(value =
            {"4000:없음",
            "5000:별",
            "10000:트리",
            "19000:트리",
            "20000:산타"},
            delimiter = ':')
    void symbolEventTest(int price, String symbol) {
        Event event = new SymbolEvent(price);
        assertThat(event.eventInfo()).isEqualTo(symbol);
    }

    @DisplayName("증정 이벤트 할인 가격에 대한 정상 테스트")
    @Test
    void giftDiscountTest() {
        GiftEvent event = new GiftEvent(120000);
        assertThat(event.getTotalDiscount()).isEqualTo(25000);
    }
}