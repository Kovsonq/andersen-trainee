package gofpatterns.Behavioral.Chain.BugTracker;

public class SmsReportNotifier extends Notifier {
    @Override
    public void write(String message) {
        System.out.println("Sending sms:" + message);
    }

    public SmsReportNotifier(int priority) {
        super(priority);
    }

}
