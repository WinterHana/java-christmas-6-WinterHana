package christmas.domain.discount;

public class WeekendDiscount implements Discount {
    private int discountPrice;
    private int totalDiscount;     // 할인 가격을 계산해서 저장
    public WeekendDiscount() {
        discountPrice = DiscountPrice.WEEKEND_DISCOUNT.getDiscount();
        totalDiscount = 0;
    }

    // main : 메인 메뉴의 개수를 입력받음
    @Override
    public int discount(int price, int main) {
        totalDiscount = main * discountPrice;
        return price - totalDiscount;
    }

    @Override
    public String toString() {
        return "주말 할인 : -" + totalDiscount  + "원";
    }
}
