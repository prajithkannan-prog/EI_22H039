class ScheduleTask implements Runnable {
    private Device device;
    private boolean turnOn;

    public ScheduleTask(Device device, boolean turnOn) {
        this.device = device;
        this.turnOn = turnOn;
    }

    @Override
    public void run() {
        if (turnOn) device.turnOn();
        else device.turnOff();
    }
}