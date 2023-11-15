package christmas.excepton;

import christmas.util.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputDayExceptionTest {
    InputDayException inputDayException;
    @BeforeEach
    void createInputDayException() {
        inputDayException = new InputDayException();
    }

    @DisplayName("잘못된 입력에 대한 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3일", "32", "0", "오늘 무슨 요일이죠?"})
    void inputExceptionTest(String inputDay) {
        assertThatThrownBy(() -> {inputDayException.inputDayException(inputDay);})
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INVALID_DAY.getMessage());
    }
}