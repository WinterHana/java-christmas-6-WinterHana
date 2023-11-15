package christmas.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {
    private Account account;

    @BeforeEach
    void createAccount() {
        account = AccountController.makeAccount("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
    }

    @DisplayName("할인 전 가격에 대한 정상 테스트")
    @Test
    void getTotalPriceNotDiscountTest() {
        assertThat(account.getTotalPriceNotDiscount()).isEqualTo(142000);
    }

    @DisplayName("출력할 총혜택 금액에 대한 정상 테스트")
    @Test
    void getTotalDiscountSumTest() {
        assertThat(account.getTotalDiscountSum()).isEqualTo(31246);
    }

    @DisplayName("할인 혜택 내역에 대한 정상 테스트")
    @Test
    void getTotalDiscountContent() {
        assertThat(account.getTotalDiscountContent()).contains(
                "크리스마스 디데이 할인: -1,200원",
                        "평일 할인: -4,046원",
                        "특별 할인: -1,000원",
                        "증정 이벤트: -25,000원"
        );
    }

    @DisplayName("증정품에 대한 가격 혜택에 대한 테스트")
    @Test
    void getGiftEventDiscountTest() {
        assertThat(account.getGiftEventDiscount()).isEqualTo(25000);
    }

    @DisplayName("뱃지 증정에 대한 이벤트 정상 테스트")
    @Test
    void getSymbolEventContentTest() {
        assertThat(account.getSymbolEventContent()).isEqualTo("산타");
    }
}