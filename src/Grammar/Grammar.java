package Grammar;

import java.io.*;
import java.util.*;

public class Grammar {
    private Set<NonTerminal> nonTerminals;
    private Set<String> terminals;
    private Map<String, List<String>> productions;
    private String startSymbol;

    public Grammar() {
        nonTerminals = new HashSet<>();
        terminals = new HashSet<>();
        productions = new HashMap<>();
    }

    public void readGrammarFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            Arrays.stream(br.readLine().split(" "))
                    .forEach(symbol -> nonTerminals.add(new NonTerminal(symbol)));
            Arrays.stream(br.readLine().split(" "))
                    .forEach(symbol -> terminals.add(String.valueOf(new Terminal(symbol))));

            startSymbol = String.valueOf(new NonTerminal(br.readLine()));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("->");
                NonTerminal lhs = new NonTerminal(parts[0].trim());
                String rhs = parts[1].trim();

                // spliting rhs into symbols and adding the rhs to the
                // Splitting rhs into symbols and adding the rhs to the production
                List<Symbol> production = new ArrayList<>();
                String nonTermName = splitLine[0].strip();
                var symbolList = parts[1].strip().split(" ");
                for (String symbolName : symbolList) {
                    Symbol symbol = null;
                    if (symbolName.equals("ε")) {
                        symbol = new Epsilon();
                    } else {
                        if (nonTerminals.contains(symbolName)) {
                            // Symbol is a nonterminal
                            symbol = new NonTerminal(symbolName);
                        } else if (terminals.contains(symbolName)) {
                            // Symbol is a terminal
                            symbol = new Terminal(symbolName);
                        }
                        // Handle the case when the symbol is neither a nonterminal nor a terminal
                    }

                    if (symbol != null) {
                        production.add(symbol);
                    } else {
                        // Handle the case when the symbol is not recognized
                        System.out.println("Unrecognized symbol: " + symbolName);
                    }
                }

                this.nonTerminals.get(nonTermName).productions.add(production);
            }
            productions.computeIfAbsent(String.valueOf(lhs), k -> new ArrayList<>())
                    .add(String.valueOf(new Production(lhs.getSymbol(), rhs)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getStartSymbol() {
        return startSymbol;
    }

    public Set<NonTerminal> getNonTerminals() {
        return nonTerminals;
    }

    public Set<String> getTerminals() {
        return terminals;
    }

    public NonTerminal GetNonterminalBySymbol(String symbol) {
        for (var nonTerminal : nonTerminals) {
            if (nonTerminal.getSymbol() == symbol)
                return nonTerminal;
        }
        return null;
    }

    public void printNonTerminals() {
        System.out.println("Non-terminals: " + nonTerminals);
    }

    public void printTerminals() {
        System.out.println("Terminals: " + terminals);
    }

    public void printProductions() {
        System.out.println("Productions: " + productions);
    }

    public void printProductionsForNonterminal(String nonterminal) {
        System.out.println("Productions for " + nonterminal + ": " + productions.get(nonterminal));
    }

    public boolean isCFG() {
        for (String nonTerminal : productions.keySet()) {
            if (!nonTerminals.contains(nonTerminal) || nonTerminal.contains(" ")) {
                return false;
            }
        }
        return true;
    }

}
