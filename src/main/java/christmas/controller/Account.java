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

    // 주문한 메뉴를 가져온다.
    public String getAllOrderedMenu() {
        return foodGenerator.printFoods();
    }

    // 할인 전 총 금액을 가져옴
    public int getTotalPriceNotDiscount() {
        return this.foodGenerator.totalPrice();
    }

    // 증정 메뉴를 제외한 총 혜택 금액을 가져온다.
    public int getTotalDiscountSumExceptGift() {
        return this.discountGenerator.getTotalDiscountSum();
    }

    // 증정 메뉴에 대한 정보를 가져온다.
    public String getGiftMenuInfo() {
        return this.eventGenerator.getGiftMenuInfo();
    }

    // 증정 메뉴가 포함된 혜택 내역을 가져온다.
    public String getTotalDiscountContent() {
        return this.discountGenerator.getTotalDiscountContent()
                 + eventGenerator.getGiftEventContent();
    }

    // 증정 제품의 가격을 가져온다.
    public int getGiftEventDiscount() {
        return eventGenerator.getGiftEventDiscount();
    }

    // 뱃지 내역에 대해 가져온다.
    public String getSymbolEventContent() {
        return eventGenerator.getSymbolEventContent();
    }

    // 출력할 총혜택 금액을 가져온다.
    public int getTotalDiscountSum() {
        return getTotalDiscountSumExceptGift() + getGiftEventDiscount();
    }
    
    // 할인 후 총 금액을 가져온다.
    public int getTotalPriceDiscount() {
        return getTotalPriceNotDiscount() - getTotalDiscountSumExceptGift();
    }
}
