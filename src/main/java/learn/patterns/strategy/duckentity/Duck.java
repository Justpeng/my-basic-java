package learn.patterns.strategy.duckentity;

import learn.patterns.strategy.duckfly.Fly;
import learn.patterns.strategy.duckquack.Quack;

/**
 * Duck超类
 *
 * @author:Just
 * @create:2016-11-30 20:50
 */
public abstract class Duck {
    Fly fly;
    Quack quack;

    public void eat(){
        System.out.println("duck eat ...");
    }
    public void fly(){
        fly.fly();
    }
    public void quack(){
        quack.quack();
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public void setQuack(Quack quack) {
        this.quack = quack;
    }
}
