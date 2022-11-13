package chucknorris;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new CommandLineInterface();
        ui.run();
    }
}