package christmas.domain.day;

import christmas.domain.discount.Discount;

import java.util.List;

/**
 * 날짜를 입력받을 때, 예외 처리는 여기서 한다.
 */
public class DayGenerator {
    private Day day;

    public DayGenerator(String inputDay) {
        day = new Day(Integer.parseInt(inputDay));
    }

    public String getDiscountContent() {
        return day.getDiscountContent();
    }




    /**
     * 예외 처리하기...
     */
}
