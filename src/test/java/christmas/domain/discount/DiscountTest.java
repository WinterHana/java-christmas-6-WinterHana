package christmas.domain.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTest {
    @DisplayName("크리스마스 할인 정상 테스트")
    @Test
    void chrismasDiscountTest() {
        Discount dc = new ChristmasDiscount();
        assertThat(dc.discount(10000, 10)).isEqualTo(8100);
    }

    @DisplayName("특별 할인 정상 테스트")
    @Test
    void specialDiscountTest() {
        Discount dc = new SpecialDiscount();
        assertThat(dc.discount(10000)).isEqualTo(9000);
    }

    @DisplayName("주간 할인 정상 테스트")
    @Test
    void weekdayDiscountTest() {
        Discount dc = new WeekdayDiscount();
        assertThat(dc.discount(152000, 5)).isEqualTo(141885);
    }

    @DisplayName("주말 할인 정상 테스트")
    @Test
    void weekendDiscountTest() {
        Discount dc = new WeekendDiscount();
        assertThat(dc.discount(126000, 7)).isEqualTo(111839);
    }
}