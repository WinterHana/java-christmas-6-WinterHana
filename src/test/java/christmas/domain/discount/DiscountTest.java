package christmas.domain.discount;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTest {
    @DisplayName("크리스마스 할인 정상 테스트")
    @Test
    void chrismasDiscountTest() {
        Discount dc = new ChristmasDiscount(10);
        assertThat(dc.getTotalDiscount()).isEqualTo(1900);
    }

    @DisplayName("특별 할인 정상 테스트")
    @Test
    void specialDiscountTest() {
        Discount dc = new SpecialDiscount();
        assertThat(dc.getTotalDiscount()).isEqualTo(1000);
    }

    @DisplayName("주간 할인 정상 테스트")
    @Test
    void weekdayDiscountTest() {
        Discount dc = new WeekdayDiscount(5);
        assertThat(dc.getTotalDiscount()).isEqualTo(10115);
    }

    @DisplayName("주말 할인 정상 테스트")
    @Test
    void weekendDiscountTest() {
        Discount dc = new WeekendDiscount(7);
        assertThat(dc.getTotalDiscount()).isEqualTo(14161);
    }
}