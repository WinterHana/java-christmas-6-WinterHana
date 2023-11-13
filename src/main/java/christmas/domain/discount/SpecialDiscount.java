package christmas.domain.discount;

public class SpecialDiscount extends Discount {
    public SpecialDiscount() {
        discountPrice = DiscountPrice.SPECIAL_DISCOUNT.getDiscount();
    }

    @Override
    public int discount(int price) {
        return price - discountPrice;
    }
}
