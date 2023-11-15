package christmas.controller;

import christmas.domain.day.DiscountGenerator;
import christmas.domain.event.EventGenerator;
import christmas.domain.food.FoodGenerator;

public class AccountController {
    public static Account makeAccount(String day, String menu) {
        FoodGenerator foodGenerator = new FoodGenerator(menu);
        DiscountGenerator discountGenerator = new DiscountGenerator(
                day, foodGenerator.countMain(), foodGenerator.countDessert());
        EventGenerator eventGenerator = new EventGenerator(
                    foodGenerator.totalPrice(), discountGenerator.getTotalDiscountSum());
        return new Account(foodGenerator, discountGenerator, eventGenerator);
    }
}
