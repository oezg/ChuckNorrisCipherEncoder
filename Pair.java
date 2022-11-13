package chucknorris;

public class Pair {
    private char key;
    private int value;

    public Pair(char key, int value) {
        this.key = key;
        this.value = value;
    }

    public char getKey() {
        return key;
    }

    public void setKey(char key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        String template = "%s %s";
        String firstBlock = getKey() == '1' ? "0" : "00";
        String secondBlock = "0".repeat(getValue());
        return String.format(template, firstBlock, secondBlock);
    }
}
