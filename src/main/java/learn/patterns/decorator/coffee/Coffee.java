package learn.patterns.decorator.coffee;


import learn.patterns.decorator.Drink;

/**
 * 咖啡主体超类与咖啡单品中间层
 * 定义咖啡单品共有的cost方法
 * Created by @Just on 2016/10/9.
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        //这里继承超类，所以直接返回价格
        return super.getPrice();
    }
}
