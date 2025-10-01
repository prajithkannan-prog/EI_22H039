import java.util.logging.*;
class Light extends Device {
    public Light(String name) {
        super(name);
    }

    @Override
    public void turnOn() {
        isOn = true;
        Logger.getLogger(Light.class.getName()).info(name + " light is turned ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        Logger.getLogger(Light.class.getName()).info(name + " light is turned OFF");
    }
}
