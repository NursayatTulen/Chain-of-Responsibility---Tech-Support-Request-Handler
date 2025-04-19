abstract class SupportHandler {
    protected SupportHandler nextHandler;
    protected Logger logger;

    public SupportHandler setNext(SupportHandler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public void setLogger(Logger logger) {
        this.logger = logger;
    }

    public abstract void handle(String issue) throws UnresolvedIssueException;
}
