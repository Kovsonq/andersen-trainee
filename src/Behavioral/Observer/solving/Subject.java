package Behavioral.Observer.solving;

public interface Subject {
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
    void change();
}
