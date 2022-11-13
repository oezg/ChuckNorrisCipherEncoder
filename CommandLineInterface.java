package chucknorris;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandLineInterface implements UserInterface {


    private final Scanner scanner;

    private final CipherEncoder cipherEncoder;
    private List<String> result;

    public CommandLineInterface() {
        this.scanner = new Scanner(System.in);
        this.result = new ArrayList<>();
        this.cipherEncoder = new CipherEncoder();
    }

    @Override
    public void run() {
        System.out.println("Input string:");
        String input = scanner.nextLine();
        result = cipherEncoder.process(input);
        System.out.println();
        System.out.println("The result:");
        result.forEach(s -> System.out.println(s));
    }
}
