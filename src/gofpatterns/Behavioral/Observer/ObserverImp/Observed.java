package gofpatterns.Behavioral.Observer.ObserverImp;

public interface Observed {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
