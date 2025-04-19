import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SmartHomeRemoteControl {
    private Map<Integer, Command> commandSlots = new HashMap<>();
    private Stack<Command> history = new Stack<>();
    private Stack<Command> redoStack = new Stack<>();

    public void setCommand(int slot, Command command) {
        commandSlots.put(slot, command);
    }

    public void pressButton(int slot) {
        Command command = commandSlots.get(slot);
        if (command != null) {
            command.execute();
            history.push(command);
            redoStack.clear();
        } else {
            System.out.println("No command assigned to slot " + slot);
        }
    }

    public void undoButton() {
        if (!history.isEmpty()) {
            Command command = history.pop();
            System.out.println("Undo last command");
            command.undo();
            redoStack.push(command);
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redoButton() {
        if (!redoStack.isEmpty()) {
            Command command = redoStack.pop();
            System.out.println("Redo last undone command");
            command.execute();
            history.push(command);
        } else {
            System.out.println("Nothing to redo");
        }
    }
}
