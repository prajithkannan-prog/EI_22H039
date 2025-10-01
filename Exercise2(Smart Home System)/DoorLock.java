import java.util.logging.Logger;

class DoorLock extends Device {
    private boolean locked;

    public DoorLock(String name) {
        super(name);
        this.locked = true; // default locked
    }

    @Override
    public void turnOn() {
        locked = false;
        isOn = true;
        Logger.getLogger(DoorLock.class.getName()).info(name + " door is UNLOCKED");
    }

    @Override
    public void turnOff() {
        locked = true;
        isOn = false;
        Logger.getLogger(DoorLock.class.getName()).info(name + " door is LOCKED");
    }

    public boolean isLocked() {
        return locked;
    }
}
