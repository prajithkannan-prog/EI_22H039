import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;
class SmartHomeHub {
    private List<Device> devices = new ArrayList<>();
    private List<Trigger> triggers = new ArrayList<>();
    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(2);
    private static final Logger logger = Logger.getLogger(SmartHomeHub.class.getName());

    public void addDevice(Device device) {
        devices.add(device);
        logger.info("Added device: " + device.getName());
    }

    public void listDevices() {
        if (devices.isEmpty()) {
            logger.warning("No devices found.");
            return;
        }
        logger.info("Devices:");
        for (int i = 0; i < devices.size(); i++) {
            Device d = devices.get(i);
            System.out.println((i + 1) + ". " + d.getName() + " [" + (d.isOn ? "ON" : "OFF") + "]");
        }
    }

    public Device getDevice(int index) {
        if (index >= 0 && index < devices.size()) {
            return devices.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid device ID");
    }

    public void scheduleTask(Device device, boolean turnOn, int delaySeconds) {
        scheduler.schedule(new ScheduleTask(device, turnOn), delaySeconds, TimeUnit.SECONDS);
        logger.info("Task scheduled for " + device.getName() + " in " + delaySeconds + " seconds.");
    }

    public void addTrigger(Trigger trigger) {
        triggers.add(trigger);
        logger.info("Trigger added for condition: " + trigger);
    }

    public void evaluateTriggers(String condition) {
        for (Trigger trigger : triggers) {
            trigger.evaluate(condition);
        }
    }

    public void shutdown() {
        scheduler.shutdown();
        logger.info("Smart Home Hub shutting down...");
    }
}