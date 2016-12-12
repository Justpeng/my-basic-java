package learn.patterns.strategy.duckfly;

/**
 * 会飞
 *
 * @author:Just
 * @create:2016-11-30 20:54
 */
public class CanFly implements Fly {
    @Override
    public void fly() {
        System.out.println("this duck can fly");
    }
}
