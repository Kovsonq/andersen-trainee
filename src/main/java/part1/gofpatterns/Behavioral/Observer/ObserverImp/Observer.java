package part1.gofpatterns.Behavioral.Observer.ObserverImp;

import java.util.List;

public interface Observer {
    public void handleEvent(List<String> vacancies);
}
