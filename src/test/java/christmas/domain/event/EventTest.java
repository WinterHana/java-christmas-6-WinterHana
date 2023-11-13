package christmas.domain.event;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {
    @DisplayName("증정 이벤트에 대한 정상 테스트")
    @Test
    void giftEvenTest() {
        Event event = new GiftEvent(120000);
        assertThat(event.eventInfo()).isEqualTo("샴페인 1개");
    }

    @DisplayName("뱃지 이벤트에 대한 정상 테스트")
    @Test
    void symbolEvenTest() {
        Event event = new SymbolEvent(15000);
        assertThat(event.eventInfo()).isEqualTo("트리");
    }
}