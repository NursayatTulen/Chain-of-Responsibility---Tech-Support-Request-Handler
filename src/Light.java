package src;
public class Light {
    private boolean isOn = false;

    public void turnOn() {
        isOn = true;
        System.out.println("[Light] Turning ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println("[Light] Turning OFF");
    }

    public boolean isOn() {
        return isOn;
    }
}
