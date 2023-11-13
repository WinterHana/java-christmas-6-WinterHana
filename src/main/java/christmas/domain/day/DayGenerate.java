package christmas.domain.day;

import java.util.List;

/**
 * 날짜를 입력받을 때, 예외 처리는 여기서 한다.
 */
public class DayGenerate {
    private Day day;

    public DayGenerate(String inputDay) {
        day = new Day(Integer.parseInt(inputDay));
    }

    public String getDiscountContent() {
        return day.getDiscountContent();
    }

    public List<DiscountDay> getDiscountDays() {
        return day.getDiscountDays();
    }


    /**
     * 예외 처리하기...
     */
}
