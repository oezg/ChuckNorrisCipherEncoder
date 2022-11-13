package chucknorris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CipherEncoder {
    public static void turnIntoBinary(String input) {
        input.chars().forEach(x -> {
            char character = (char) x;
            String binary = Integer.toBinaryString(x);
            String template = String.format("%c = %d", character, binary);
            System.out.println(template);
        });
    }

    public static String spacer(String input) {
        return spacer(input, " ");
    }

    public static String spacer(String input, String space) {
        return Stream.of(input.split(""))
                .collect(Collectors.joining(space));
    }

    public List<String> process(String input) {
        List<String> result = new ArrayList<>();
        List<String> letters = input.chars().mapToObj(Integer::toBinaryString).toList();
        for (int i = 0; i < input.length(); i++) {
            String binaryNumber = String.format("%7s", letters.get(i)).replace(' ', '0');
            result.add(String.format("%c = %s", input.charAt(i), binaryNumber));
        }
        return result;
    }


    private List<String> turnStringIntoListLetters(String input) {
        return input.chars().mapToObj(Character::toString).toList();
    }
}
