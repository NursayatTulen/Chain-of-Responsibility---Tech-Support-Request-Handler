import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmartHomeRemoteControlApp {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();
        Door door = new Door();

        Command turnOnLight = new TurnOnLightCommand(light);
        Command turnOffLight = new TurnOffLightCommand(light);
        Command setThermostat = new SetThermostatCommand(thermostat, 22);
        Command lockDoor = new LockDoorCommand(door);

        List<Command> goodnightCommands = new ArrayList<>();
        goodnightCommands.add(turnOffLight);
        goodnightCommands.add(new SetThermostatCommand(thermostat, 18));
        goodnightCommands.add(lockDoor);
        Command goodnightMode = new GoodnightModeCommand(goodnightCommands);

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand(1, turnOnLight);
        remote.setCommand(2, setThermostat);
        remote.setCommand(3, goodnightMode);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nSmart Home Remote Control Menu:");
            System.out.println("1. Turn On Light (Slot 1)");
            System.out.println("2. Set Thermostat to 22°C (Slot 2)");
            System.out.println("3. Goodnight Mode (Slot 3)");
            System.out.println("4. Undo Last Command");
            System.out.println("5. Redo Last Undone Command");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remote.pressButton(1);
                    break;
                case 2:
                    remote.pressButton(2);
                    break;
                case 3:
                    remote.pressButton(3);
                    break;
                case 4:
                    remote.undoButton();
                    break;
                case 5:
                    remote.redoButton();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting Smart Home Remote Control");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
