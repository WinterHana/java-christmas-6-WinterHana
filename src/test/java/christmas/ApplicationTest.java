package christmas;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    void 모든_타이틀_출력() {
        assertSimpleTest(() -> {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            );
        });
    }

    @Test
    void 혜택_내역_없음_출력() {
        assertSimpleTest(() -> {
            run("26", "타파스-1,제로콜라-1");
            assertThat(output()).contains("<혜택 내역>" + LINE_SEPARATOR + "없음");
        });
    }

    @Test
    void 날짜_예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        });
    }

    @Test
    void 주문_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3", "제로콜라-a");
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        });
    }

    @DisplayName("10000원 이하의 정상 작동 테스트")
    @Test
    void notDiscountNormalTest() {
        assertSimpleTest(() -> {
            run("8", "아이스크림-1, 제로콜라-1");
            assertThat(output()).contains(
                    "아이스크림 1개",
                    "제로콜라 1개",
                    "8,000원",
                    "없음"
            );
        });
    }

    @DisplayName("10000원 이상의 정상 작동 테스트")
    @Test
    void discountNormalTest() {
        assertSimpleTest(() -> {
            run("17", "아이스크림-1, 제로콜라-1, 크리스마스파스타-1");
            assertThat(output()).contains(
                    "아이스크림 1개",
                    "제로콜라 1개",
                    "크리스마스파스타 1개",
                    "33,000원",
                    "크리스마스 디데이 할인: -2,600원",
                    "특별 할인: -1,000원",
                    "평일 할인: -2,023원",
                    "-5,623원",
                    "27,377원",
                    "별"
            );
        });
    }

    @DisplayName("120000원 이상의 정상 작동 테스트")
    @Test
    void normalTest() {
        assertSimpleTest(() -> {
            run("23", "티본스테이크-2,바비큐립-1,초코케이크-2");
            assertThat(output()).contains(
                    "티본스테이크 2개",
                    "바비큐립 1개",
                    "초코케이크 2개",
                    "194,000원",
                    "샴페인 1개",
                    "크리스마스 디데이 할인: -3,200원",
                    "주말 할인: -6,069원",
                    "증정 이벤트: -25,000원",
                    "-34,269원",
                    "184,731원",
                    "산타"
            );
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
