package christmas.domain.event;

public class SymbolEvent implements Event {
    final int starPrice = 5000;
    final int treePrice = 10000;
    final int santaPrice = 20000;
    Symbol symbol;

    public SymbolEvent(int price) {
        symbol = Symbol.NOTHING;
    }

    private void giveSymbol(int price) {
        if(price >= Symbol.STAR.getPrice()) {
            symbol = Symbol.STAR;
        }
        if(price >= Symbol.TREE.getPrice()) {
            symbol = Symbol.TREE;
        }
        if(price >= Symbol.SANTA.getPrice()) {
            symbol = Symbol.SANTA;
        }
    }
    @Override
    public String eventInfo() {
        return symbol.getName();
    }
}
