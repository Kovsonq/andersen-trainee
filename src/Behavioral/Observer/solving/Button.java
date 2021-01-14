package Behavioral.Observer.solving;


import java.util.ArrayList;

public class Button implements Subject {
    java.util.List<Observer> observerList = new ArrayList<>();

    public void clicked(){
        change();
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observerList.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observerList.remove(observer);
    }

    @Override
    public void change() {
        for (Observer observer : observerList){
            observer.update();
        }
    }
}
