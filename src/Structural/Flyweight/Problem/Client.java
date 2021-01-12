package Structural.Flyweight.Problem;

public class Client {
    public static void main(String[] args) {
        WordProcessor processor = new WordProcessor();

        String textToDo = "Hello i'm a word processor";
        int length = textToDo.length();

        for (int i = 0; i < length; i++) {
            String value = textToDo.substring(i, i+1);
            processor.addLetter(new Letter(value));
        }

        processor.printLetters();

    }
}
