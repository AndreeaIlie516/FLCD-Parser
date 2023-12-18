import Grammar.Grammar;
import Parser.RecursiveDescent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grammar grammar = new Grammar();
        grammar.readGrammarFromFile("src/g1.in");

        List<String> sequence = readSequenceFromFile("src/sequence1.in");

        RecursiveDescent parser = new RecursiveDescent(grammar, sequence);

        parser.parse();
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("\n--- Grammar Menu ---");
//            System.out.println("1. Print Non-Terminals");
//            System.out.println("2. Print Terminals");
//            System.out.println("3. Print Productions");
//            System.out.println("4. Print Productions for a Nonterminal");
//            System.out.println("5. Check if CFG");
//            System.out.println("0. Exit");
//            System.out.print("Enter your choice: ");
//
//            int choice = scanner.nextInt();
//            switch (choice) {
//                case 1:
//                    grammar.printNonTerminals();
//                    break;
//                case 2:
//                    grammar.printTerminals();
//                    break;
//                case 3:
//                    grammar.printProductions();
//                    break;
//                case 4:
//                    System.out.print("Enter Nonterminal: ");
//                    String nonterminal = scanner.next();
//                    grammar.printProductionsForNonTerminal(nonterminal);
//                    break;
//                case 5:
//                    System.out.println("Is CFG: " + grammar.isCFG());
//                    break;
//                case 0:
//                    System.out.println("Exiting...");
//                    return;
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//        }
    }

    public static List<String> readSequenceFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<String> sequence = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                sequence.add(line);
            }
            return sequence;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}