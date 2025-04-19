package src;
import java.util.List;

public class GoodnightModeCommand implements Command {
    private List<Command> commands;

    public GoodnightModeCommand(List<Command> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println("[Macro] Executing Goodnight Mode");
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        System.out.println("[Macro] Undoing Goodnight Mode");
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}
