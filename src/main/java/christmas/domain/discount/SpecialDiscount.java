package christmas.domain.discount;

import christmas.util.SpotPrice;

public class SpecialDiscount implements Discount {
    private int discountPrice;
    private int totalDiscount;     // 할인 가격을 계산해서 저장
    public SpecialDiscount() {
        discountPrice = DiscountPrice.SPECIAL_DISCOUNT.getDiscount();
        discount();
    }

    @Override
    public void discount() {
        totalDiscount = discountPrice;
    }

    @Override
    public int getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public String toString() {
        return "특별 할인: "
                + SpotPrice.addPriceSpot((-1) * totalDiscount)  + "원";
    }
}
