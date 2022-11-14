package chucknorris;


import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ChuckNorrisDecoder {
    public String decode(String input) throws ChuckNorrisDecoderException {

        if (input.chars().filter(ch->(ch=='0'||ch==' ')).count() != input.length()) {
            throw new EncodedMessageIncludesCharactersOtherThanZeroOrSpacesException();
        }
        if (input.split(" ").length % 2 != 0) {
            throw new NumberOfBlocksIsOddException();
        }

        for (int i = 0; i < input.split(" ").length; i += 2) {
            if ("0".equals(input.split(" ")[i]) || "00".equals(input.split(" ")[i])) {
                continue;
            }
            throw new FirstBlockOfEachSequenceIsNotZeroOrSpace();
        }

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

        if (decodedInput.length() % 7 != 0) {
            throw new LengthOfDecodedBinaryStringIsNotMultipleOfSevenException();
        }

        return Pattern.compile("[01]{7}")
                .matcher(decodedInput)
                .results()
                .map(MatchResult::group)
                .mapToInt(string -> Integer.parseInt(string, 2))
                .collect(StringBuilder::new,
                        StringBuilder::appendCodePoint,
                        StringBuilder::append)
                .toString();

    }

    public class ChuckNorrisDecoderException extends Exception{

    }

    private class LengthOfDecodedBinaryStringIsNotMultipleOfSevenException extends ChuckNorrisDecoderException {

    }
    private class NumberOfBlocksIsOddException extends ChuckNorrisDecoderException {
    }

    private class EncodedMessageIncludesCharactersOtherThanZeroOrSpacesException extends ChuckNorrisDecoderException {
    }

    private class FirstBlockOfEachSequenceIsNotZeroOrSpace extends ChuckNorrisDecoderException {
    }
}
