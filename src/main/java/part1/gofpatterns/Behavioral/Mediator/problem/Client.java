package part1.gofpatterns.Behavioral.Mediator.problem;

/**
 * We want to show which object we select in some field
 * It's working, but when we multiple our app, work will become more and more complicated
 * We have to use Mediator for making our work easy
 */
public class Client {
    public static void main(String[] args) {
        List list = new List();
        InputText text = new InputText();

        list.setInputText(text);

        list.getItems().add("Data one");
        list.getItems().add("Data two");
        list.getItems().add("Data three");

        list.selectItem(0);

        System.out.println("Selected value is: " + text.getValue());

    }

}
