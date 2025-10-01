import java.util.*;
import java.util.logging.*;
public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.INFO); 
        SmartHomeHub hub = new SmartHomeHub();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Smart Home System ---");
            System.out.println("1. Add Device");
            System.out.println("2. List Devices");
            System.out.println("3. Turn On Device");
            System.out.println("4. Turn Off Device");
            System.out.println("5. Schedule Task");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        System.out.print("Enter device type (light/fan/thermostat): ");
                        String type = sc.nextLine();
                        System.out.print("Enter device name: ");
                        String name = sc.nextLine();
                        hub.addDevice(DeviceFactory.createDevice(type, name));
                        break;

                    case 2:
                        hub.listDevices();
                        break;

                    case 3:
                        hub.listDevices();
                        System.out.print("Enter device number: ");
                        int onId = Integer.parseInt(sc.nextLine()) - 1;
                        hub.getDevice(onId).turnOn();
                        break;

                    case 4:
                        hub.listDevices();
                        System.out.print("Enter device number: ");
                        int offId = Integer.parseInt(sc.nextLine()) - 1;
                        hub.getDevice(offId).turnOff();
                        break;

                    case 5:
                        hub.listDevices();
                        System.out.print("Enter device number: ");
                        int sId = Integer.parseInt(sc.nextLine()) - 1;
                        System.out.print("Turn ON or OFF (on/off): ");
                        boolean turnOn = sc.nextLine().equalsIgnoreCase("on");
                        System.out.print("Enter delay in seconds: ");
                        int delay = Integer.parseInt(sc.nextLine());
                        hub.scheduleTask(hub.getDevice(sId), turnOn, delay);
                        break;

                    case 6:
                        hub.shutdown();
                        sc.close();
                        return;

                    default:
                        logger.warning("Invalid option. Try again.");
                }
            } catch (NumberFormatException e) {
                logger.severe("Invalid input. Please enter a number.");
            } catch (Exception e) {
                logger.severe("Error: " + e.getMessage());
            }
        }
    }
}