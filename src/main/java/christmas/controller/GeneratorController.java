package christmas.controller;

import christmas.domain.day.DiscountGenerator;
import christmas.domain.event.EventGenerator;
import christmas.domain.food.FoodGenerator;

public class GeneratorController {
    public FoodGenerator getFoodGenerator(String menu) {
        return new FoodGenerator(menu);
    }

    public DiscountGenerator getDiscountGenerator(String day, int main, int dessert) {
        return new DiscountGenerator(day, main, dessert);
    }

    public EventGenerator getEventGenerator(int priceNotDiscount, int totalDiscount) {
        return new EventGenerator(priceNotDiscount, totalDiscount);
    }
}
