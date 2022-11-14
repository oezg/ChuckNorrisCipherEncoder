package chucknorris;


import java.util.Scanner;

public class CommandLineInterface implements UserInterface {


    private final Scanner scanner;
    public CommandLineInterface() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        ChuckNorrisEncoder encoder = new ChuckNorrisEncoder();
        ChuckNorrisDecoder decoder = new ChuckNorrisDecoder();
        String input;
        String code;
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            String operation = scanner.nextLine();
            if ("encode".equalsIgnoreCase(operation)) {
                System.out.println("Input string:");
                input = scanner.nextLine();
                code = encoder.encode(input);
                System.out.println("Encoded string:");
                System.out.println(code);
            } else if ("decode".equalsIgnoreCase(operation)) {
                System.out.println("Input encoded string");
                input = scanner.nextLine();
                try {
                    code = decoder.decode(input);
                    System.out.println("Decoded string:");
                    System.out.println(code);
                } catch (ChuckNorrisDecoder.ChuckNorrisDecoderException e) {
                    System.out.println("Encoded string is not valid.");
                }
            } else if ("exit".equalsIgnoreCase(operation)) {
                break;
            } else {
                System.out.printf("There is no '%s' operation\n", operation);
            }
            System.out.println();
        }
        System.out.println("Bye!");
    }
}
