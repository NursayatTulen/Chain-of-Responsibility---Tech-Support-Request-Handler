class UnresolvedIssueException extends Exception {
    public UnresolvedIssueException(String issue) {
        super("Issue could not be resolved: " + issue);
    }
}
