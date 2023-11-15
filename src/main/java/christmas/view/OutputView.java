package christmas.view;

import christmas.controller.Account;
import christmas.controller.AccountController;
import christmas.util.SpotPrice;

public class OutputView {
    private Account account;
    public OutputView(String day, String menu) {
        account = AccountController.makeAccount(day, menu);
        System.out.printf("12월 %s일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n\n", day);
    }

    public void outputResult() {
        outputMenu();
        outputTotalPriceNotDiscount();
        outputGiftMenu();
        outputTotalDiscountContent();
        outputTotalDiscountSum();
        outputTotalPriceDiscount();
        outputSymbolEventContent();
    }
    private void outputMenu() {
        System.out.println("<주문 메뉴>");
        System.out.println(account.getAllOrderedMenu());
    }

    private void outputTotalPriceNotDiscount() {
        System.out.println("<할인 전 총주문 금액>");
        account.getTotalPriceNotDiscount();
        System.out.println(SpotPrice.addPriceSpot(account.getTotalPriceNotDiscount()) + "원\n");
    }

    private void outputGiftMenu() {
        System.out.println("<증정 메뉴>");
        System.out.println(account.getGiftMenuInfo() + "\n");
    }

    private void outputTotalDiscountContent() {
        System.out.println("<혜택 내역>");
        System.out.println(account.getTotalDiscountContent());
    }

    private void outputTotalDiscountSum() {
        System.out.println("<총혜택 금액>");
        System.out.println(SpotPrice.addPriceSpot(account.getTotalDiscountSum()) + "원\n");
    }

    private void outputTotalPriceDiscount() {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(SpotPrice.addPriceSpot(account.getTotalPriceDiscount()) + "원\n");
    }

    private void outputSymbolEventContent() {
        System.out.println("<12월 이벤트 배지>");
        System.out.println(account.getSymbolEventContent() + "\n");
    }
}
