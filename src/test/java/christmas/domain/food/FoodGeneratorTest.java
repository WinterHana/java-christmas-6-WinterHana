package christmas.domain.food;

import christmas.domain.food.FoodGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @Test
    void sumTotalPrice() {
        FoodGenerator foodGenerator = new FoodGenerator("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");
        assertThat(foodGenerator.totalPrice()).
                isEqualTo(142000);
    }

    @DisplayName("디저트 메뉴 개수 정상 테스트")
    @Test
    void countDessertMenu() {
        FoodGenerator foodGenerator = new FoodGenerator("바비큐립-3,아이스크림-3,초코케이크-2,제로콜라-1");
        assertThat(foodGenerator.countDessert()).isEqualTo(5);
    }

    @DisplayName("메인 메뉴 개수 정상 테스트")
    @Test
    void countMainMenu() {
        FoodGenerator foodGenerator = new FoodGenerator("해산물파스타-3,아이스크림-5,샴페인-2,양송이수프-1,크리스마스파스타-10");
        assertThat(foodGenerator.countMain()).isEqualTo(13);
    }
}