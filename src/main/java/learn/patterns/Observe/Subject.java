package learn.patterns.Observe;

/**
 * Description: 主题
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 06/02/2017-16:44
 */
public interface Subject {
    void registerObserver(String id,Observer o);//注册观察者

    void removeObserver(String id);//移除观察者

    void notifyObservers();//通知观察者
}
