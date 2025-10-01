import java.util.logging.*;
class Fan extends Device {
    public Fan(String name) {
        super(name);
    }

    @Override
    public void turnOn() {
        isOn = true;
        Logger.getLogger(Fan.class.getName()).info(name + " fan is turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        Logger.getLogger(Fan.class.getName()).info(name + " fan is turned OFF");
    }
}