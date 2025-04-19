public class Thermostat {
    private int temperature = 20;
    private int previousTemperature;

    public void setTemperature(int temp) {
        previousTemperature = temperature;
        temperature = temp;
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
    }

    public void revertTemperature() {
        temperature = previousTemperature;
        System.out.println("[Thermostat] Reverting to previous temperature: " + temperature + "°C");
    }

    public int getTemperature() {
        return temperature;
    }
}
