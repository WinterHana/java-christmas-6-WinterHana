package christmas.domain.food;

import christmas.util.RegularExpression;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열을 받아 Food에 대한 Map을 만든다.
 * 그 후 관련 기능은 여기서 실행한다.
 */
public class FoodGenerator {
    private Map<Food, Integer> foods;

    public FoodGenerator(String inputFood) {
        foods = new HashMap<>();
        generateFoods(inputFood);
    }

    // "," 기준으로 나누기
    private void generateFoods(String inputFood) {
        String[] splitMenu = inputFood.split(",");
        Arrays.stream(splitMenu).forEach(menu -> {
            menu = menu.replaceAll(" ", "");
            splitFoods(menu);
        });
    }

    // 메뉴 형식에 맞춰서 고치기 Map에 추가하기
    private void splitFoods(String menu) {
        Pattern pattern = Pattern.compile(RegularExpression.REGEXP_PATTERN_MENU.getRegExp());
        Matcher matcher = pattern.matcher(menu);
        if(matcher.matches()) {
            String foodName = matcher.group(1);
            int foodNumber = Integer.parseInt(matcher.group(2));
            Optional<Food> food = Arrays.stream(Food.values())
                    .filter(f -> foodName.equals(f.getName()))
                    .findFirst();
            foods.put(food.get(), foodNumber);
        }
    }

    // foods의 내용 출력하기
    public String printFoods() {
        StringBuffer foodsInfo = new StringBuffer();
        foods.entrySet().stream().forEach(food -> {
                    foodsInfo.append(food.getKey().getName() + " " + food.getValue() + "개\n");
                });
        return foodsInfo.toString();
    }

    // 총 가격 계산
    public int totalPrice() {
        return foods.entrySet().stream()
                .mapToInt(food -> food.getKey().getPrice() * food.getValue())
                .sum();
    }

    // 각 메뉴의 개수 출력(디저트, 메인, 에피타이저, 음료)
    public int countDessert() {
        return (int) foods.entrySet().stream()
                .filter(food -> food.getKey().getMenu() == Menu.DESSERT)
                .mapToInt(food -> food.getValue())
                .sum();
    }

    public int countAppetizer() {
        return (int) foods.entrySet().stream()
                .filter(food -> food.getKey().getMenu() == Menu.APPETIZER)
                .mapToInt(food -> food.getValue())
                .sum();
    }

    public int countBeverage() {
        return (int) foods.entrySet().stream()
                .filter(food -> food.getKey().getMenu() == Menu.BEVERAGE)
                .mapToInt(food -> food.getValue())
                .sum();
    }

    public int countMain() {
        return (int) foods.entrySet().stream()
                .filter(food -> food.getKey().getMenu() == Menu.MAIN)
                .mapToInt(food -> food.getValue())
                .sum();
    }

    // 총 메뉴의 개수 출력
    public int countAllMenu() {
        return (int) foods.entrySet().stream()
                .mapToInt(food -> food.getValue())
                .sum();
    }

    // 음료만 주문했는지 확인하기
    public boolean isOnlyBeverage() {
        if(countBeverage() == countAllMenu()) {
            return true;
        }
        return false;
    }
}
