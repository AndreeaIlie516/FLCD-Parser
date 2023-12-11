package Grammar;

public class NonTerminal implements Symbol{
    private String symbol;

    public NonTerminal(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}