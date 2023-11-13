package christmas.domain.day;

public enum DiscountDay {
    CHRISMAS("크리스마스 할인"),
    SPECIAL("특별 할인"),
    WEEKDAY("주중 할인"),
    WEEKEND("주말 할인");

    private String name;

    DiscountDay(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
