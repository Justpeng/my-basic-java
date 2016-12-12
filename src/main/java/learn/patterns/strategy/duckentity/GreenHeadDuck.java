package learn.patterns.strategy.duckentity;

import learn.patterns.strategy.duckfly.CanFly;
import learn.patterns.strategy.duckquack.LongQuack;


/**
 * 红头Duck
 *
 * @author:Just
 * @create:2016-11-30 20:53
 */
public class GreenHeadDuck extends Duck {
    public GreenHeadDuck() {
        fly = new CanFly();
        quack = new LongQuack();
    }
    @Override
    public void eat(){
        System.out.println("green duck eat");
    }

    @Override
    public void fly(){
        fly.fly();
    }
    @Override
    public void quack(){
        quack.quack();
    }


}
