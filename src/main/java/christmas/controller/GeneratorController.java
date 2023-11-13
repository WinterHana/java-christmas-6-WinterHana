package christmas.controller;

import christmas.domain.day.DayGenerator;
import christmas.domain.day.DiscountDay;
import christmas.domain.discount.ChristmasDiscount;
import christmas.domain.discount.Discount;
import christmas.domain.event.Event;
import christmas.domain.event.GiftEvent;
import christmas.domain.event.SymbolEvent;
import christmas.domain.food.FoodGenerator;

import java.util.ArrayList;
import java.util.List;

public class GeneratorController {
    public FoodGenerator getFoodGenerator(String menu) {
        return new FoodGenerator(menu);
    }

    public DayGenerator getDayGenerator(String day) {
        return new DayGenerator(day);
    }
}
