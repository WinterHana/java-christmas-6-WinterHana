package christmas;

import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        String day = inputView.inputDay();
        String menu = inputView.inputMenu();
        OutputView outputView = new OutputView(day, menu);
        outputView.outputResult();
    }
}
