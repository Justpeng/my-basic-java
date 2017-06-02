package learn.patterns.Observe;

import lombok.Data;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description: 主题实现类
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 06/02/2017-16:53
 */
@Data
public class WeatherData implements Subject {
    private Map<String,Observer> observers;

    private float temperature;

    private float humidity;

    private float pressure;

    public WeatherData() {
        observers = new ConcurrentHashMap<>();
    }

    @Override
    public void registerObserver(String id,Observer o) {
        observers.put(id, o);
    }

    @Override
    public void removeObserver(String id) {
        if (observers.containsKey(id)) {
            observers.remove(id);
        }
    }

    @Override
    public void notifyObservers() {
        observers.forEach((k,o) -> o.update(temperature,humidity,pressure));
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    /**
     * 气象站更新数据
     * @param temperature
     * @param humidity
     * @param pressure
     */
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

}
