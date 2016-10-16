package learn.patterns.decorator.decorator;

import design.patterns.decorator.Drink;

/**
 * Created by @Just on 2016/10/9.
 */
public class Soy extends Decorator {
    public Soy(Drink obj) {
        super(obj);
        setPrice(4.5f);
        setDescription("Soy");
    }
}
