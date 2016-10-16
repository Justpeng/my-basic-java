package learn.patterns.decorator.coffee;

/**
 * 咖啡单品继承中间类
 * Created by @Just on 2016/10/9.
 */
public class Decaf extends Coffee {
    /**
     * 实例化-初始化价格和描述
     */
    public Decaf() {
        setPrice(22f);
        setDescription("Decaf");
    }
}
