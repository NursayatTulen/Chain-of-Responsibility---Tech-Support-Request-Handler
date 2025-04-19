public class TechSupportRequestHandler {
    public static void main(String[] args) {
        Logger logger = new Logger();

        FAQBotHandler faq = new FAQBotHandler();
        JuniorSupportHandler junior = new JuniorSupportHandler();
        SeniorSupportHandler senior = new SeniorSupportHandler();

        faq.setLogger(logger);
        junior.setLogger(logger);
        senior.setLogger(logger);

        faq.setNext(junior).setNext(senior);

        String[] issues = {"password_reset", "refund_request", "account_ban", "unknown_bug"};

        for (String issue : issues) {
            System.out.println("\nProcessing issue: " + issue);
            try {
                faq.handle(issue);
            } catch (UnresolvedIssueException e) {
                System.out.println("[System] " + e.getMessage());
            }
        }
    }
}