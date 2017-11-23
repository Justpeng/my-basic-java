package learn.patterns.singleton;

/**
 * Description: 有益于性能的单例模式
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 09/26/2017-16:26
 */
public class Singleton {
    private volatile static Singleton uniqueInstance;

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
