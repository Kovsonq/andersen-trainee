package gofpatterns.Behavioral.Observer.solution;

public class InputText implements Observer {
    public void setText(String text){
        System.out.println("Inputtext set text: " + text);
    }

    @Override
    public void update() {
        this.setText("Button has been clicked");
    }

}
