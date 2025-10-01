class Trigger {
    private String condition;
    private Device device;
    private boolean turnOn;

    public Trigger(String condition, Device device, boolean turnOn) {
        this.condition = condition;
        this.device = device;
        this.turnOn = turnOn;
    }

    public void evaluate(String currentCondition) {
        if (condition.equalsIgnoreCase(currentCondition)) {
            if (turnOn) device.turnOn();
            else device.turnOff();
        }
    }
}