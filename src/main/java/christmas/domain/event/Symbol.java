package christmas.domain.event;

/**
 * 이벤트 뱃지에 대한 내용
 */
public enum Symbol {
    STAR("별", 5000),
    TREE("트리", 10000),
    SANTA("산타", 20000),
    NOTHING("없음", 0);

    private String name;
    private int price;

    Symbol(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
