class FAQBotHandler extends SupportHandler {
    @Override
    public void handle(String issue) throws UnresolvedIssueException {
        if (logger != null) logger.log("[FAQBot] Attempting to handle " + issue);
        if (issue.equals("password_reset")) {
            System.out.println("[FAQBot] Handled " + issue);
            if (logger != null) logger.log("[FAQBot] Successfully handled " + issue);
        } else if (nextHandler != null) {
            if (logger != null) logger.log("[FAQBot] Cannot handle " + issue + " — passing to next handler");
            nextHandler.handle(issue);
        } else {
            if (logger != null) logger.log("[FAQBot] Failed to handle " + issue + " — no next handler");
            throw new UnresolvedIssueException(issue);
        }
    }
}