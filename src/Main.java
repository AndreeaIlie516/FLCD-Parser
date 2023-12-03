import Grammar.Grammar;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Grammar grammar = new Grammar();
        grammar.readGrammarFromFile("src/g1.in");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Grammar Menu ---");
            System.out.println("1. Print Non-Terminals");
            System.out.println("2. Print Terminals");
            System.out.println("3. Print Productions");
            System.out.println("4. Print Productions for a Nonterminal");
            System.out.println("5. Check if CFG");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    grammar.printNonTerminals();
                    break;
                case 2:
                    grammar.printTerminals();
                    break;
                case 3:
                    grammar.printProductions();
                    break;
                case 4:
                    System.out.print("Enter Nonterminal: ");
                    String nonterminal = scanner.next();
                    grammar.printProductionsForNonterminal(nonterminal);
                    break;
                case 5:
                    System.out.println("Is CFG: " + grammar.isCFG());
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}