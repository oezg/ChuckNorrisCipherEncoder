package chucknorris;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CipherEncoder {

    public static String spacer(String input) {
        return spacer(input, " ");
    }

    public static String spacer(String input, String space) {
        return Stream.of(input.split(""))
                .collect(Collectors.joining(space));
    }

    public String encode(String input) {
        List<String> letters = getLettersAsListOfBinaryStrings(input);
        return IntStream
                .range(0, Math.min(input.length(), letters.size()))
                .mapToObj(i -> String.format("%c = %s", input.charAt(i), letters.get(i)))
                .collect(Collectors.joining("\n"));
    }

    protected List<String> getLettersAsListOfBinaryStrings(String input) {
        return input.chars().mapToObj(Integer::toBinaryString)
                .map(s -> String.format("%7s", s).replace(' ', '0'))
                .toList();
    }
}
