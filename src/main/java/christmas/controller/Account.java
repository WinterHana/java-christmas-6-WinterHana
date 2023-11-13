package christmas.controller;

import christmas.domain.day.DayGenerator;
import christmas.domain.discount.Discount;
import christmas.domain.event.Event;
import christmas.domain.food.FoodGenerator;

import java.util.List;

/**
 * 총 계산서를 만든다.
 */
public class Account {
    FoodGenerator foodGenerator;
    DayGenerator dayGenerator;
    public Account(FoodGenerator foodGenerator, DayGenerator dayGenerator) {
        this.foodGenerator = foodGenerator;
        this.dayGenerator = dayGenerator;
    }
}
