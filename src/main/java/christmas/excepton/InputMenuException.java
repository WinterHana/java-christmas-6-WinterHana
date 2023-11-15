package christmas.excepton;

import christmas.domain.food.Food;
import christmas.domain.food.FoodGenerator;
import christmas.util.ErrorMessage;
import christmas.util.RegularExpression;

import java.util.Arrays;
import java.util.regex.Pattern;

public class InputMenuException {
    FoodGenerator foodGenerator;
    public void inputMenuException(String inputFood) throws IllegalArgumentException {
        checkInputFood(inputFood);
        foodGenerator = new FoodGenerator(inputFood);
    }
    
    // 입력 형식에 대한 예외
    private void checkInputFood(String inputFood) throws IllegalArgumentException {
        String[] splitMenu = inputFood.split(",");
        Arrays.stream(splitMenu).forEach(menu -> {
            menu = menu.replace(" ", "");
            checkMenuPattern(menu);
        });
    }

    private void checkMenuPattern(String menu) throws IllegalArgumentException {
        if(!Pattern.matches(RegularExpression.REGEXP_PATTERN_MENU.getRegExp(), menu)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INVALID_ORDER.getMessage());
        }
    }
    
    // 메뉴판에 없는 메뉴를 입력했을 때
    
    // 중복 메뉴를 입력했을 때
    
    // 총 주문 개수가 20개를 초과했을 때
    
    // 음료만 주문했을 때
}
