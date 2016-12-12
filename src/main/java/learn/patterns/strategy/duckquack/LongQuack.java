package learn.patterns.strategy.duckquack;

/**
 * 叫声长
 *
 * @author:Just
 * @create:2016-11-30 20:56
 */
public class LongQuack implements Quack {
    @Override
    public void quack() {
        System.out.println("duck long quack");
    }
}
