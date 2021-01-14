package Behavioral.Observer.solving;

public class Client {
    public static void main(String[] args) {
        Button button = new Button();
        InputText inputText = new InputText();
        List list = new List();

        button.attachObserver(inputText);
        button.attachObserver(list);

        button.clicked();
    }
}
