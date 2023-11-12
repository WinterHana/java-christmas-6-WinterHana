package christmas.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 문자열을 받아 Food에 대한 Map을 만든다.
 * 메뉴 입력에 대한 예외 처리를 여기서 진행한다.
 */
public class FoodGenerator {
    private Map<Food, Integer> foods;

    public FoodGenerator(String inputFood) {
        foods = new HashMap<>();
        generateFoods(inputFood);
    }

    public Map<Food, Integer> getFoods() {
        return foods;
    }
    
    // foods의 내용 출력하기
    public String printFoods() {
        StringBuffer foodsInfo = new StringBuffer();
        foods.entrySet().stream().forEach(food -> {
            foodsInfo.append(food.getKey().getName() + " " + food.getValue() + "개\n");
        });
        return foodsInfo.toString();
    }
    
    // "," 기준으로 나누기
    private void generateFoods(String inputFood) {
        String[] splitMenu = inputFood.split(",");
        Arrays.stream(splitMenu).forEach(menu -> {
            menu.replaceAll(" ", "");
            splitFoods(menu);
        });
    }
    
    // "-" 기준으로 나누기
    private void splitFoods(String splitMenu) {
        String[] splitFoodAndInt = splitMenu.split("-");
        String foodName = splitFoodAndInt[0];
        String foodNumber = splitFoodAndInt[1];
        Arrays.stream(Food.values()).forEach(food -> {
            if(foodName.equals(food.getName())) {
                foods.put(food, Integer.parseInt(foodNumber));
            }
        });
    }
}
