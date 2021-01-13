package Behavioral.Chain.BugTracker;

public class SimpleReportNotifier extends Notifier {
    @Override
    public void write(String message) {
        System.out.println("Notifying using simple report:" + message);
    }

    public SimpleReportNotifier(int priority) {
        super(priority);
    }

}
