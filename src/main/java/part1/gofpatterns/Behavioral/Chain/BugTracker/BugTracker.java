package part1.gofpatterns.Behavioral.Chain.BugTracker;

public class BugTracker {
    public static void main(String[] args) {
        Notifier simpleReportNotifier = new SimpleReportNotifier(Priority.ROUTINE);
        Notifier emailReportNotifier = new EmailReportNotifier(Priority.IMPORTANT);
        Notifier smsReportNotifier = new SmsReportNotifier(Priority.ASAP);

        simpleReportNotifier.setNextNotifier(emailReportNotifier);
        emailReportNotifier.setNextNotifier(smsReportNotifier);

        simpleReportNotifier.notifyManager("Ok", Priority.ROUTINE);
        simpleReportNotifier.notifyManager("Not ok", Priority.IMPORTANT);
        simpleReportNotifier.notifyManager("OMG!!!", Priority.ASAP);

    }
}
