package christmas.controller;

import christmas.domain.day.DiscountGenerator;
import christmas.domain.event.Event;
import christmas.domain.food.FoodGenerator;

import java.util.List;

/**
 * 총 계산서를 만든다.
 */
public class Account {
    private FoodGenerator foodGenerator;
    private DiscountGenerator discountGenerator;
    private List<Event> events;

    public Account(FoodGenerator foodGenerator, DiscountGenerator discountGenerator) {
        this.foodGenerator = foodGenerator;
        this.discountGenerator = discountGenerator;
    }

    // 할인 전 총 금액을 가져옴
    public int getTotalPriceNotDiscount() {
        return this.foodGenerator.totalPrice();
    }

    // 총 혜택 금액을 가져온다.
}
