package src;
public class LockDoorCommand implements Command {
    private Door door;

    public LockDoorCommand(Door door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.lock();
    }

    @Override
    public void undo() {
        door.unlock();
    }
}
