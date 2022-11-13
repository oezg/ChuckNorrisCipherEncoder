package chucknorris;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ChuckNorrisEncoder extends CipherEncoder {

    private final List<Pair> norris = new LinkedList<>();
    @Override
    public String encode(String input) {
        String chainedBinaryLetters = String.join("", getLettersAsListOfBinaryStrings(input));
        if (chainedBinaryLetters.isEmpty()) {
            return "";
        }
        int counter = 1;
        Pair firstPair = new Pair(chainedBinaryLetters.charAt(0), counter);
        this.norris.add(firstPair);
        for (int i = 1; i < chainedBinaryLetters.length(); i++) {
            Pair currentPair = norris.get(norris.size() - 1);
            if (currentPair.getKey() == chainedBinaryLetters.charAt(i)) {
                counter++;
            } else {
                norris.get(norris.size() - 1).setValue(counter);
                counter = 1;
                norris.add(new Pair(chainedBinaryLetters.charAt(i), counter));
            }
        }
        norris.get(norris.size() - 1).setValue(counter);
        return norris.stream()
                .map(Pair::toString)
                .collect(Collectors.joining(" "));
    }
}
