class SeniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) throws UnresolvedIssueException {
        if (logger != null) logger.log("[SeniorSupport] Attempting to handle " + issue);
        if (issue.equals("account_ban") || issue.equals("data_loss")) {
            System.out.println("[SeniorSupport] Handled " + issue);
            if (logger != null) logger.log("[SeniorSupport] Successfully handled " + issue);
        } else if (nextHandler != null) {
            if (logger != null) logger.log("[SeniorSupport] Cannot handle " + issue + " — passing to next handler");
            nextHandler.handle(issue);
        } else {
            if (logger != null) logger.log("[SeniorSupport] Failed to handle " + issue + " — escalate manually");
            throw new UnresolvedIssueException(issue);
        }
    }
}