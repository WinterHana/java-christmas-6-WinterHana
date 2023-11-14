package christmas.domain.day;

import christmas.domain.discount.Discount;

import java.util.List;

/**
 * 날짜를 입력받을 때, 예외 처리는 여기서 한다.
 */
public class DiscountGenerator {
    private DayDiscount dayDiscount;

    public DiscountGenerator(String inputDay, int menu, int dessert) {
        dayDiscount = new DayDiscount(Integer.parseInt(inputDay), menu, dessert);
    }

    public String getDiscountContent() {
        return dayDiscount.getDiscountContent();
    }

    public List<Discount> getDiscounts() {
        return dayDiscount.getDiscounts();
    }

    public int getTotal

    /**
     * 예외 처리하기...
     */
}
