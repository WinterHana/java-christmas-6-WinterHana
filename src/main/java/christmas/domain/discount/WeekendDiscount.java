package christmas.domain.discount;

import christmas.util.SpotPrice;

public class WeekendDiscount implements Discount {
    private int discountPrice;
    private int totalDiscount;     // 할인 가격을 계산해서 저장
    private int main;
    public WeekendDiscount(int main) {
        discountPrice = DiscountPrice.WEEKEND_DISCOUNT.getDiscount();
        discount(main);
    }

    // main : 메인 메뉴의 개수를 입력받음
    @Override
    public void discount(int main) {
        totalDiscount = main * discountPrice;
    }

    @Override
    public int getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public String toString() {
        return "주말 할인: "
                + SpotPrice.addPriceSpot((-1) * totalDiscount)  + "원";
    }
}
