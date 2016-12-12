package learn.patterns.strategy.test;

import learn.patterns.strategy.duckentity.Duck;
import learn.patterns.strategy.duckentity.GreenHeadDuck;
import learn.patterns.strategy.duckentity.RedHeadDuck;
import learn.patterns.strategy.duckfly.CanFly;

/**
 * @author:Just
 * @create:2016-11-30 21:00
 */
public class TestDuck {
    public static void main(String args[]){
        Duck redHeadDuck = new RedHeadDuck();
        Duck greenHeadDuck = new GreenHeadDuck();

        redHeadDuck.eat();
        redHeadDuck.fly();
        redHeadDuck.quack();
        System.out.println("****** ****** ****** ******");
        greenHeadDuck.eat();
        greenHeadDuck.setFly(new CanFly());
        greenHeadDuck.fly();
        greenHeadDuck.quack();



    }
}
