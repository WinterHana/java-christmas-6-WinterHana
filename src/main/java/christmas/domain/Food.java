package christmas.domain;

public enum Food {
    // 애피타이저
    MUSHROOM_SOUP(Menu.APPETIZER,"양송이수프", 6000),
    TAPAS(Menu.APPETIZER,"타파스", 5500),
    CAESAR_SALAD(Menu.APPETIZER,"시저샐러드", 8000),

    // 메인
    T_BONE_STEAK(Menu.MAIN, "티본스테이크", 55000),
    BBQ_RIBS(Menu.MAIN,"바비큐립", 54000),
    SEAFOOD_PASTA(Menu.MAIN,"해산물파스타", 35000),
    CHRISTMAS_PASTA(Menu.MAIN,"크리스마스파스타", 25000),

    // 디저트
    CHOCOLATE_CAKE(Menu.DESSERT,"초코케이크", 15000),
    ICE_CREAM(Menu.DESSERT"아이스크림", 5000),

    // 음료
    ZERO_COLA(Menu.BEVERAGE, "제로콜라", 3000),
    RED_WINE(Menu.BEVERAGE, "레드와인", 60000),
    CHAMPAGNE(Menu.BEVERAGE, "샴페인", 25000);

    private Menu menu;
    private String name;
    private int price;

    Food(Menu menu, String name, int price) {
        this.menu = menu;
        this.name = name;
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
