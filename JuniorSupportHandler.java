class JuniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) throws UnresolvedIssueException {
        if (logger != null) logger.log("[JuniorSupport] Attempting to handle " + issue);
        if (issue.equals("refund_request") || issue.equals("billing_issue")) {
            System.out.println("[JuniorSupport] Handled " + issue);
            if (logger != null) logger.log("[JuniorSupport] Successfully handled " + issue);
        } else if (nextHandler != null) {
            if (logger != null) logger.log("[JuniorSupport] Cannot handle " + issue + " — passing to next handler");
            nextHandler.handle(issue);
        } else {
            if (logger != null) logger.log("[JuniorSupport] Failed to handle " + issue + " — no next handler");
            throw new UnresolvedIssueException(issue);
        }
    }
}