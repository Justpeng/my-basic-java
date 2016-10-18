package learn.patterns.decorator.decorator;

import learn.patterns.decorator.Drink;

/**
 * 调料类-Milk继承装饰类
 * Created by @Just on 2016/10/9.
 */
public class Milk extends  Decorator{
    /**
     * 将被包装类进行包装
     * @param obj
     */
    public Milk(Drink obj) {
        super(obj);
        setPrice(3.2f);
        setDescription("Milk");
    }
}
