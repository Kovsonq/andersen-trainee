package part1.gofpatterns.Behavioral.Observer.problem;

public class Client {
    public static void main(String[] args) {
        Button button = new Button();
        InputText inputText = new InputText();
        List list = new List();

        button.setInputText(inputText);
        button.setList(list);
        button.clicked();
    }
}
