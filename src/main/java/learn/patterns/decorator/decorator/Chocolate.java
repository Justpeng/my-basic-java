package learn.patterns.decorator.decorator;


import learn.patterns.decorator.Drink;

/**
 * Created by @Just on 2016/10/9.
 */
public class Chocolate extends Decorator {

    public Chocolate(Drink obj) {
        super(obj);
        setPrice(6.4f);
        setDescription("Chocolate");
    }
}
