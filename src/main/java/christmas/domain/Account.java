package christmas.domain;

/**
 * 총 계산서를 만든다.
 */
public class Account {
    FoodGenerator foodGenerator;

    public Account(FoodGenerator foodGenerator) {
        this.foodGenerator = foodGenerator;
    }
}
