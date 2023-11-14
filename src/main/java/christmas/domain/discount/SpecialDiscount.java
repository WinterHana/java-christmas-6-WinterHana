package christmas.domain.discount;

public class SpecialDiscount implements Discount {
    private int discountPrice;
    private int totalDiscount;     // 할인 가격을 계산해서 저장
    public SpecialDiscount() {
        discountPrice = DiscountPrice.SPECIAL_DISCOUNT.getDiscount();
        totalDiscount = 0;
    }

    @Override
    public int discount() {
        totalDiscount = discountPrice;
        return totalDiscount;
    }

    @Override
    public int getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public String toString() {
        return "특별 할인 : -" + totalDiscount  + "원";
    }
}
