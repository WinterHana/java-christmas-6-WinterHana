package christmas.excepton;

import christmas.domain.food.Food;
import christmas.domain.food.FoodGenerator;
import christmas.util.ErrorMessage;
import christmas.util.RegularExpression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputMenuException {
    final int MAXIMUM_ORDER = 20;
    FoodGenerator foodGenerator;
    List<String> foods;

    public InputMenuException() {
        foods = new ArrayList<>();
    }

    // 여기에 예외 상황에 대한 메서드를 모아둔다.
    public void inputMenuException(String inputFood) throws IllegalArgumentException {
        foods.clear();
        checkInputFood(inputFood);
        foodGenerator = new FoodGenerator(inputFood);
        checkAllMenuCount();
        checkOnlyBeverage();
    }

    // 한 묶음의 메뉴를 받으면 메뉴 이름을 반환한다.
    private String getMenuName(String menu) {
        Pattern pattern = Pattern.compile(RegularExpression.REGEXP_PATTERN_MENU.getRegExp());
        Matcher matcher = pattern.matcher(menu);
        if(matcher.matches()) {
            String foodName = matcher.group(1);
            return foodName;
        }
        return null;
    }

    // 문자열 분리 후, 적절한 예외 검사를 추가한다.
    private void checkInputFood(String inputFood) throws IllegalArgumentException {
        String[] splitMenu = inputFood.split(",");
        Arrays.stream(splitMenu).forEach(menu -> {
            menu = menu.replace(" ", "");
            checkMenuPattern(menu);             // 입력의 패턴 확인
            checkRepeatedOrder(menu);           // 반복되는 주문이 아닌지 확인
            checkNotInMenu(menu);               // 메뉴가 아예 없는 것인지 확인
            foods.add(getMenuName(menu));       // 최종적으로 foods에 추가한다.
        });
    }

    // 입력 형식에 맞지 않게 입력했을 때
    private void checkMenuPattern(String menu) throws IllegalArgumentException {
        if(!Pattern.matches(RegularExpression.REGEXP_PATTERN_MENU.getRegExp(), menu)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INVALID_ORDER.getMessage());
        }
    }

    // 메뉴판에 없는 메뉴를 입력했을 때
    private void checkNotInMenu(String menu) throws IllegalArgumentException {
        String foodName = getMenuName(menu);
        int menuCount = (int) Arrays.stream(Food.values())
                .filter(f -> foodName.equals(f.getName()))
                .count();
        if(menuCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INVALID_ORDER.getMessage());
        }

    }

    // 중복 메뉴를 입력했을 때
    private void checkRepeatedOrder(String menu) {
        String foodName = getMenuName(menu);
        if(foods.contains(foodName)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INVALID_ORDER.getMessage());
        }
    }

    // 총 주문 개수가 20개를 초과했을 때
    private void checkAllMenuCount() throws IllegalArgumentException {
        if(foodGenerator.countAllMenu() > MAXIMUM_ORDER) {
            throw new IllegalArgumentException(ErrorMessage.ORDER_EXCEEDED.getMessage());
        }
    }

    // 음료만 주문했을 때
    private void checkOnlyBeverage() throws IllegalArgumentException {
        if(foodGenerator.isOnlyBeverage()) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_BEVERAGE.getMessage());
        }
    }
}
