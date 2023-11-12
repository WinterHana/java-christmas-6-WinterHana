package christmas.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FoodGeneratorTest {
    @DisplayName("자동 생성 테스트")
    @Test
    void createFoodGenerator() {
        FoodGenerator foodGenerator = new FoodGenerator("타파스-1,제로콜라-1");
        assertThat(foodGenerator.printFoods()).
                contains("제로콜라 1개", "타파스 1개");
    }
}