package learn.patterns.decorator.decorator;

import design.patterns.decorator.Drink;

/**
 * 装饰器对象
 * Created by @Just on 2016/10/9.
 */
public class Decorator extends Drink {
    /**
     * 待装饰对象：可能是单品咖啡
     * 也可能是已包装过的单品咖啡
     * 所以是超类对象，由具体实现而定
     */
    private  Drink obj;

    public Decorator(Drink obj) {
        this.obj = obj;
    }

    public float cost() {
        //获取自身包装的价格 + 被包装对象的价格(递归)
        return super.getPrice()+ obj.cost();
    }

    public String getDescription() {
        return super.description+"-"+super.getPrice()+" && "+obj.getDescription();
    }
}
