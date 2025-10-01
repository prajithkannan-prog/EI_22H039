import java.util.logging.*;
class Thermostat extends Device {
    private int temperature;

    public Thermostat(String name, int temperature) {
        super(name);
        this.temperature = temperature;
    }

    @Override
    public void turnOn() {
        isOn = true;
        Logger.getLogger(Thermostat.class.getName()).info(name + " thermostat is ON at " + temperature + "°C");
    }

    @Override
    public void turnOff() {
        isOn = false;
        Logger.getLogger(Thermostat.class.getName()).info(name + " thermostat is OFF");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        Logger.getLogger(Thermostat.class.getName()).info(name + " temperature set to " + temperature + "°C");
    }
}
