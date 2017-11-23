package learn.patterns.Observe;

/**
 * Description: 观察者
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 06/02/2017-16:44
 */
public interface Observer {
    void update(float temp, float humidity, float pressure);//更新天气
}
