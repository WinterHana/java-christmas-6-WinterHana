package christmas.domain.day;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public class Day {
    private LocalDate date;
    private List<DiscountDay> discountDays;

    public Day(int day) {
        date = LocalDate.of(2023, 12, day);
    }

    public List<DiscountDay> getDiscountDays() {
        return Collections.unmodifiableList(discountDays);
    }

    private void addDiscount() {
        addChrismasDiscount();
        addSpecialDiscount();
        addWeekendDiscount();
        addWeekdayDiscount();
    }

    // 1일과 25일 사이에는 크리스마스 디데이 할인
    private void addChrismasDiscount() {
        if (date.getDayOfMonth() >= 1 || date.getDayOfMonth() <= 25) {
            discountDays.add(DiscountDay.CHRISMAS);
        }
    }

    // 일요일이거나 크리스마스 당일일 때 특별 할인
    private void addSpecialDiscount() {
        if (date.getDayOfWeek() == DayOfWeek.SUNDAY
                || date.getDayOfMonth() == 25) {
            discountDays.add(DiscountDay.SPECIAL);
        }
    }

    // 금요일, 토요일에는 주말 할인
    private void addWeekendDiscount() {
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY
                || date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            discountDays.add(DiscountDay.WEEKEND);
        }
    }

    // 일요일 ~ 목요일에는 평일 할인
    private void addWeekdayDiscount() {
        if (date.getDayOfWeek() == DayOfWeek.MONDAY
                || date.getDayOfWeek() == DayOfWeek.TUESDAY
                || date.getDayOfWeek() == DayOfWeek.WEDNESDAY
                || date.getDayOfWeek() == DayOfWeek.THURSDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            discountDays.add(DiscountDay.WEEKDAY);
        }
    }
}
