package christmas.controller;

import christmas.domain.day.DiscountGenerator;
import christmas.domain.event.Event;
import christmas.domain.event.EventGenerator;
import christmas.domain.food.FoodGenerator;

import java.util.List;

/**
 * 총 계산서를 만든다.
 */
public class Account {
    private FoodGenerator foodGenerator;
    private DiscountGenerator discountGenerator;
    private EventGenerator eventGenerator;

    public Account(FoodGenerator foodGenerator
            , DiscountGenerator discountGenerator
            , EventGenerator eventGenerator) {
        this.foodGenerator = foodGenerator;
        this.discountGenerator = discountGenerator;
        this.eventGenerator = eventGenerator;
    }

    // 할인 전 총 금액을 가져옴
    public int getTotalPriceNotDiscount() {
        return this.foodGenerator.totalPrice();
    }

    // 총 혜택 금액을 가져온다.
    public int getTotalDiscountSum() {
        return this.discountGenerator.getTotalDiscountSum();
    }

    // 혜택 내역을 가져온다.
    public String getTotalDiscountContent() {
        return this.discountGenerator.getTotalDiscountContent();
    }

    // 증정 내역를 반환한다.
    public String getGiftEventContent() {
        return eventGenerator.getGiftEventContent();
    }

    // 증정 제품의 가격을 반환한다.
    public int getGiftEventDiscount() {
        return eventGenerator.getGiftEventDiscount();
    }

    // 뱃지 내역에 대해 반환한다.
    public String getSymbolEventContent() {
        return eventGenerator.getSymbolEventContent();
    }


}
