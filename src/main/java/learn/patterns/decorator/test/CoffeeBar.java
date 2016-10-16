package learn.patterns.decorator.test;

import design.patterns.decorator.Drink;
import design.patterns.decorator.coffee.Decaf;
import design.patterns.decorator.decorator.Chocolate;
import design.patterns.decorator.decorator.Milk;
import design.patterns.decorator.decorator.Soy;

/**
 * Created by @Just on 2016/10/9.
 */
public class CoffeeBar {
    public static void main(String args[]) {
        Drink order =  new Decaf();

        System.out.println("order price:"+order.cost());
        System.out.println("order dec:"+order.getDescription());
        System.out.println();
        order = new Milk(order);
        order = new Chocolate(order);
        order = new Soy(order);
        System.out.println("order2 price:"+order.cost());
        System.out.println("order2 dec:"+order.getDescription());
    }
}
