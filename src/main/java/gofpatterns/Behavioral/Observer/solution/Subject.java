package gofpatterns.Behavioral.Observer.solution;

public interface Subject {
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
    void change();
}
