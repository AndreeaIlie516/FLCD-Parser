package Grammar;

import java.io.BufferedReader;

import java.io.*;
import java.util.*;

public class Grammar {
    private Set<String> nonTerminals;
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
                    .forEach(symbol -> nonTerminals.add(String.valueOf(new NonTerminal(symbol))));
            Arrays.stream(br.readLine().split(" "))
                    .forEach(symbol -> terminals.add(String.valueOf(new Terminal(symbol))));

            startSymbol = String.valueOf(new NonTerminal(br.readLine()));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("->");
                NonTerminal lhs = new NonTerminal(parts[0].trim());
                String rhs = parts[1].trim();
                productions.computeIfAbsent(String.valueOf(lhs), k -> new ArrayList<>())
                        .add(String.valueOf(new Production(lhs.getSymbol(), rhs)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

