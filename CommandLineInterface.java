package chucknorris;

import java.util.List;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {


    private final Scanner scanner;
    public CommandLineInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        System.out.println("Input encoded string:");
        String input = scanner.nextLine();

        ChuckNorrisDecoder chuckNorrisDecoder = new ChuckNorrisDecoder();

        String result = chuckNorrisDecoder.decode(input);
        System.out.println();
        System.out.println("The result:");
        System.out.println(result);
    }
}
