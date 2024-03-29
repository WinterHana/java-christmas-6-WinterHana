package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.excepton.InputDayException;
import christmas.excepton.InputMenuException;

public class InputView {
    InputDayException inputDayException;
    InputMenuException inputMenuException;

    public InputView() {
        inputDayException = new InputDayException();
        inputMenuException = new InputMenuException();
    }

    public String inputDay() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        System.out.println("12월 중 식당 예상 방문 날씨는 언제인가요? (숫자만 입력해 주세요!)");
        String input = "";
        while(true) {
            try {
                input = Console.readLine();
                inputDayException.inputDayException(input);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    public String inputMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = "";
        while(true) {
            try {
                input = Console.readLine();
                inputMenuException.inputMenuException(input);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }
}
