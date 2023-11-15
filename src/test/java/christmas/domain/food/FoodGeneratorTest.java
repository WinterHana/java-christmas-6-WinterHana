package christmas.domain.food;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FoodGeneratorTest {
    @DisplayName("자동 생성 정상 테스트")
    @Test
    void createFoodGenerator() {
        FoodGenerator foodGenerator = new FoodGenerator("타파스-1,제로콜라-1");
        assertThat(foodGenerator.printFoods()).
                contains("제로콜라 1개", "타파스 1개");
    }

    @DisplayName("합계 계산 정상 테스트")
    @ParameterizedTest
    @CsvSource(value =
            {"바비큐립-3,아이스크림-3,초코케이크-2,제로콜라-1:210000",
            "시저샐러드-1,양송이수프-3:26000",
            "아이스크림-5,샴페인-2,양송이수프-1,크리스마스파스타-2:131000",
            "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1:142000"},
            delimiter = ':')
    void sumTotalPrice(String inputMenu, int sum) {
        FoodGenerator foodGenerator = new FoodGenerator(inputMenu);
        assertThat(foodGenerator.totalPrice()).isEqualTo(sum);
    }

    @DisplayName("디저트 메뉴 개수 정상 테스트")
    @ParameterizedTest
    @CsvSource(value =
            {"바비큐립-3,아이스크림-3,초코케이크-2,제로콜라-1:5",
            "시저샐러드-1,양송이수프-3:0",
            "아이스크림-5,샴페인-2,양송이수프-1,크리스마스파스타-2:5"},
            delimiter = ':')
    void countDessertMenu(String inputMenu, int output) {
        FoodGenerator foodGenerator = new FoodGenerator(inputMenu);
        assertThat(foodGenerator.countDessert()).isEqualTo(output);
    }

    @DisplayName("메인 메뉴 개수 정상 테스트")
    @ParameterizedTest
    @CsvSource(value =
            {"티본스테이크-1,초코케이크-2,아이스크림-2,바비큐립-1:2",
            "초코케이크-3,시저샐러드-1,양송이수프-3:0",
            "해산물파스타-3,아이스크림-5,샴페인-2,양송이수프-1,크리스마스파스타-10:13"},
            delimiter = ':')
    void countMainMenu(String inputMenu, int output) {
        FoodGenerator foodGenerator = new FoodGenerator(inputMenu);
        assertThat(foodGenerator.countMain()).isEqualTo(output);
    }

    @DisplayName("에피타이저 메뉴 개수 정상 테스트")
    @ParameterizedTest
    @CsvSource(value =
            {"제로콜라-1,초코케이크-2,아이스크림-3,타파스-1:1",
            "티본스테이크-3,시저샐러드-1,양송이수프-3:4",
            "제로콜라-1:0"},
            delimiter = ':')
    void countAppetizerMenu(String inputMenu, int output) {
        FoodGenerator foodGenerator = new FoodGenerator(inputMenu);
        assertThat(foodGenerator.countAppetizer()).isEqualTo(output);
    }
}