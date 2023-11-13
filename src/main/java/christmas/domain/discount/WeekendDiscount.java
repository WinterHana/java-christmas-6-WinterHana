package christmas.domain.discount;

public class WeekendDiscount extends Discount {
    private int main;   // main : 메인 메뉴의 개수를 입력받음
    public WeekendDiscount(int main) {
        discountPrice = DiscountPrice.WEEKEND_DISCOUNT.getDiscount();
        this.main = main;
    }
    

    @Override
    public int discount(int price) {
        return price - (main * discountPrice);
    }
}
