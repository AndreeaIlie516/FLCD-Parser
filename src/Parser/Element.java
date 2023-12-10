package Parser;

import Grammar.Epsilon;
import Grammar.NonTerminal;
import Grammar.Symbol;
import Grammar.Terminal;

import java.util.List;
import java.util.stream.Collectors;

public class Element {
    Symbol symbol;
    int index;

    public Element(Symbol symbol, int index) {
        this.symbol = symbol;
        this.index = index;
    }

    public Element(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void incIndex() {
        this.index++;
    }

    public NonTerminal getNonTerminal() {
        return (NonTerminal) this.symbol;
    }

    public Terminal getTerminal() {
        return (Terminal) this.symbol;
    }

    public boolean isNonTerminal() {
        return this.symbol instanceof NonTerminal;
    }

    public boolean isTerminal() {
        return this.symbol instanceof Terminal;
    }

    public boolean isEpsilon() {
        return this.symbol instanceof Epsilon;
    }

    public static List<Element> symbolsToElements(List<Symbol> symbols) {
        return symbols.stream().map(s -> new Element(s, 0)).collect(Collectors.toList());
    }

    public List<Symbol> getProductionAtIndex() {
        return this.getNonTerminal().getProductions().get(this.index);
    }

}