package learn.patterns.Observe;

import lombok.Data;

/**
 * Description: 观察者1
 *
 *
 * 实现了DisplayElement接口，因为我们的API规定所有的布告板都必须实现此接
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 06/02/2017-17:05
 */
@Data
public class CurrentConditionsDisplay implements Observer,DisplayElement {
    private  String id;
    private float temperature;
    private float humidity;
    private float pressure;

    private Subject weatherData;

    public CurrentConditionsDisplay(String id, Subject weatherData) {
        this.weatherData = weatherData;
        this.id = id;
        weatherData.registerObserver(this.id,this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature
                + "F degrees and " + humidity + "% humidity");
    }
}
