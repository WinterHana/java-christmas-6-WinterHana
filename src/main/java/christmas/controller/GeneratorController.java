package christmas.controller;

import christmas.domain.day.DiscountGenerator;
import christmas.domain.food.FoodGenerator;

public class GeneratorController {
    public FoodGenerator getFoodGenerator(String menu) {
        return new FoodGenerator(menu);
    }

    public DiscountGenerator getDayGenerator(String day) {
        return new DiscountGenerator(day);
    }
}
