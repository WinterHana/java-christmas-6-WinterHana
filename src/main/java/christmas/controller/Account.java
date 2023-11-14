package christmas.controller;

import christmas.domain.day.DayGenerator;
import christmas.domain.day.DiscountDay;
import christmas.domain.discount.Discount;
import christmas.domain.event.Event;
import christmas.domain.food.FoodGenerator;

import java.util.List;

/**
 * 총 계산서를 만든다.
 */
public class Account {
    private FoodGenerator foodGenerator;
    private DayGenerator dayGenerator;
    private List<Event> events;

    public Account(FoodGenerator foodGenerator, DayGenerator dayGenerator) {
        this.foodGenerator = foodGenerator;
        this.dayGenerator = dayGenerator;
    }

    // 할인 전 총 금액을 가져옴
    public int getTotalPriceNotDiscount() {
        return this.foodGenerator.totalPrice();
    }


}
