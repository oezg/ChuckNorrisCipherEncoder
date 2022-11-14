package chucknorris;


import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ChuckNorrisDecoder {
    public String decode(String input) {

        String decodedInput = Pattern.compile("0{1,2} 0+")
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .map(string -> string.split(" "))
                .map(strings -> {
                    String oneOrZero = strings[0].equals("0") ? "1" : "0";
                    return oneOrZero.repeat(strings[1].length());
                })
                .collect(Collectors.joining());
        return Pattern.compile("[10]{7}")
                .matcher(decodedInput)
                .results()
                .map(MatchResult::group)
                .mapToInt(string -> Integer.parseInt(string, 2))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

    }
}
