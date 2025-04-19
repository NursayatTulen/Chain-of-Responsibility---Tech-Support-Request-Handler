public class Door {
    private boolean isLocked = false;

    public void lock() {
        isLocked = true;
        System.out.println("[Door] Locking the door");
    }

    public void unlock() {
        isLocked = false;
        System.out.println("[Door] Unlocking the door");
    }

    public boolean isLocked() {
        return isLocked;
    }
}
