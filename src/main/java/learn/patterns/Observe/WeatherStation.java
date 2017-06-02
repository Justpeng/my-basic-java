package learn.patterns.Observe;

/**
 * Description: 气象站
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 06/02/2017-17:22
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay("1",weatherData);
        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.removeObserver(currentDisplay.getId());
        weatherData.setMeasurements(78, 90, 29.2f);

//        currentDisplay.display();
    }
}
