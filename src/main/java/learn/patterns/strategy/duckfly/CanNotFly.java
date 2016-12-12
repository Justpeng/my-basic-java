package learn.patterns.strategy.duckfly;

/**
 * 不会飞
 *
 * @author:Just
 * @create:2016-11-30 20:55
 */
public class CanNotFly implements Fly {
    @Override
    public void fly() {
        System.out.println("this duck can not fly");
    }
}
