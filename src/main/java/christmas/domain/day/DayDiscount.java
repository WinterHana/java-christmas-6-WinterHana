package christmas.domain.day;

import christmas.domain.discount.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayDiscount {
    private LocalDate date;
    private ArrayList<Discount> discounts;

    public DayDiscount(int day) {
        discounts = new ArrayList<>();
        date = LocalDate.of(2023, 12, day);
        addDiscount();
    }

    public List<Discount> getDiscounts() {
        return discounts;
    }
    
    // 테스트를 위한 메서드
    public String getDiscountContent() {
        if(discounts.isEmpty()) {
            return "없음";
        }
        StringBuffer stringBuffer = new StringBuffer();
        discounts.stream().forEach(day -> {
            stringBuffer.append(day + "/");
        });
        return stringBuffer.toString();
    }

    // 일수에 따른 할인률을 추가한다.
    private void addDiscount() {
        addChrismasDiscount();
        addSpecialDiscount();
        addWeekendDiscount();
        addWeekdayDiscount();
    }

    // 1일과 25일 사이에는 크리스마스 디데이 할인
    private void addChrismasDiscount() {
        if (date.getDayOfMonth() >= 1 && date.getDayOfMonth() <= 25) {
            discounts.add(new ChristmasDiscount());
        }
    }

    // 일요일이거나 크리스마스 당일일 때 특별 할인
    private void addSpecialDiscount() {
        if (date.getDayOfWeek() == DayOfWeek.SUNDAY
                || date.getDayOfMonth() == 25) {
            discounts.add(new SpecialDiscount());
        }
    }

    // 금요일, 토요일에는 주말 할인
    private void addWeekendDiscount() {
        if (date.getDayOfWeek() == DayOfWeek.FRIDAY
                || date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            discounts.add(new WeekendDiscount());
        }
    }

    // 일요일 ~ 목요일에는 평일 할인
    private void addWeekdayDiscount() {
        if (date.getDayOfWeek() == DayOfWeek.MONDAY
                || date.getDayOfWeek() == DayOfWeek.TUESDAY
                || date.getDayOfWeek() == DayOfWeek.WEDNESDAY
                || date.getDayOfWeek() == DayOfWeek.THURSDAY
                || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            discounts.add(new WeekdayDiscount());
        }
    }
}
