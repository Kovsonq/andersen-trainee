package Behavioral.Chain.BugTracker;

public class EmailReportNotifier extends Notifier {
    @Override
    public void write(String message) {
        System.out.println("Email report:" + message);
    }

    public EmailReportNotifier(int priority) {
        super(priority);
    }

}
