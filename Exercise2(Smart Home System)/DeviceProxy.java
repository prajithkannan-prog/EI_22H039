import java.util.logging.Logger;

class DeviceProxy extends Device {
    private Device realDevice;

    public DeviceProxy(Device realDevice) {
        super(realDevice.getName());
        this.realDevice = realDevice;
    }

    @Override
    public void turnOn() {
        Logger.getLogger(DeviceProxy.class.getName()).info("Proxy: Turning ON " + realDevice.getName());
        realDevice.turnOn();
    }

    @Override
    public void turnOff() {
        Logger.getLogger(DeviceProxy.class.getName()).info("Proxy: Turning OFF " + realDevice.getName());
        realDevice.turnOff();
    }
}
