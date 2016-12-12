package learn.patterns.strategy.duckentity;

import learn.patterns.strategy.duckfly.CanNotFly;
import learn.patterns.strategy.duckquack.ShortQuack;

/**
 * 红头Duck
 *
 * @author:Just
 * @create:2016-11-30 20:53
 */
public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        fly = new CanNotFly();
        quack = new ShortQuack();
    }
    @Override
    public void eat(){
        System.out.println("red duck eat");
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
