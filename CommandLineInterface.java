package chucknorris;

import java.util.List;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {


    private final Scanner scanner;
    private final CipherEncoder cipherEncoder;

    public CommandLineInterface() {
        this.scanner = new Scanner(System.in);
        this.cipherEncoder = new ChuckNorrisEncoder();
    }

    @Override
    public void run() {
        System.out.println("Input string:");
        String input = scanner.nextLine();
        String result = cipherEncoder.encode(input);
        System.out.println();
        System.out.println("The result:");
        System.out.println(result);
    }
}
