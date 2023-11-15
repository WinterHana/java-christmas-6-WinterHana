package christmas.excepton;

import christmas.util.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputMenuExceptionTest {

    private InputMenuException inputMenuException;

    @BeforeEach
    void createInputMenuException() {
        inputMenuException = new InputMenuException();
    }

    @DisplayName("입력 형식에 대한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "양송이수프-1, 타파스-0,     초코케이크-1",        // 1 미만의 수를 입력
            "티본스테이크-AD,   제로콜라-1"                      // 개수 입력 시 숫자 이외의 글자가 입력됐을 때
    })
    void inputExceptionTest(String inputMenu) {
        assertThatThrownBy(() -> {inputMenuException.inputMenuException(inputMenu);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INVALID_ORDER.getMessage());
    }

    @DisplayName("주문량에 대한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "양송이수프-11,시저샐러드-10",
            "티본스테이크-5,제로콜라-5,크리스마스파스타-5,아이스크림-6"
    })
    void maxOrderExceptionTest(String inputMenu) {
        assertThatThrownBy(() -> {inputMenuException.inputMenuException(inputMenu);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ORDER_EXCEEDED.getMessage());
    }

    @DisplayName("음료만 주문한 것에 대한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "제로콜라-1,레드와인-2,샴페인-5"
    })
    void onlyBeverageExceptionTest(String inputMenu) {
        assertThatThrownBy(() -> {inputMenuException.inputMenuException(inputMenu);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_BEVERAGE.getMessage());
    }

    @DisplayName("메뉴판에 없는 메뉴를 주문한 것에 대한 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "시저샐러드-1,바비큐립-2,간장치킨-1,아이스크림-2",
            "불고기피자-2"
    })
    void notInMenuExceptionTest(String inputMenu) {
        assertThatThrownBy(() -> {inputMenuException.inputMenuException(inputMenu);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INVALID_ORDER.getMessage());
    }

    @DisplayName("메뉴 주문이 반복됐을 때 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "시저샐러드-1,바비큐립-2,시저샐러드-1",
            "바비큐립-3,바비큐립-2",
            "시저샐러드-1"
    })
    void repeatedOrderExceptionTest(String inputMenu) {
        assertThatThrownBy(() -> {inputMenuException.inputMenuException(inputMenu);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INVALID_ORDER.getMessage());
    }
}