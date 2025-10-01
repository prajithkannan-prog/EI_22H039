import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(float temperature);
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}

class PhoneDisplay implements Observer {
    public void update(float temperature) {
        System.out.println("Phone Display: Temp = " + temperature + "°C");
    }
}

class TVDisplay implements Observer {
    public void update(float temperature) {
        System.out.println("TV Display: Temp = " + temperature + "°C");
    }
}

public class WeatherStationDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.addObserver(new TVDisplay());

        station.setTemperature(28.5f);
        station.setTemperature(30.0f);
    }
}
