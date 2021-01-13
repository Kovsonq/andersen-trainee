package Behavioral.Observer.ObserverImp;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();

        jobSite.addVacancy("1 java position");
        jobSite.addVacancy("2 java position");

        Observer firstSub = new Subscriber("Alex");
        Observer secondSub = new Subscriber("Peter");

        jobSite.addObserver(firstSub);
        jobSite.addObserver(secondSub);

        jobSite.addVacancy("New Trainee!");

        jobSite.removeVacancy("1 java position");
    }
}
