package gofpatterns.Behavioral.Observer.solution;

public class List implements Observer {
    public void setListValue(int value){
        System.out.println("Set LIST value:" + value);
    }

    @Override
    public void update() {
        this.setListValue(1);
    }
}
