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
            "티본스테이크-AD,   제로콜라-1",                      // 개수 입력 시 숫자 이외의 글자가 입력됐을 때
    })
    void inputExceptionTest(String inputMenu) {
        assertThatThrownBy(() -> {inputMenuException.inputMenuException(inputMenu);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INVALID_ORDER.getMessage());
    }
}