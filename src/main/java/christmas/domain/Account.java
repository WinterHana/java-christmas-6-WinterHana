package christmas.domain;

import christmas.domain.discount.Discount;

import java.util.List;

/**
 * 총 계산서를 만든다.
 */
public class Account {
    FoodGenerator foodGenerator;
    List<Discount> discountDetail;

    public Account(FoodGenerator foodGenerator, List<Discount> discountDetail) {
        this.foodGenerator = foodGenerator;
        this.discountDetail = discountDetail;
    }
}