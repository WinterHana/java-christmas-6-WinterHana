package christmas.domain.discount;

public class SpecialDiscount extends Discount {
    public SpecialDiscount() {
        discountPrice = DiscountPrice.SPECIAL_DISCOUNT.getDiscount();
    }

    // star : 달력에 별이 있는 날이면 1, 그 외에는 0
    @Override
    public int discount(int price, int star) {
        if(star != 0 || star != 1) return price;
        return price - discountPrice * star;
    }
}
