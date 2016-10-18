package learn.patterns.decorator.test;


import learn.patterns.decorator.Drink;
import learn.patterns.decorator.coffee.Decaf;
import learn.patterns.decorator.decorator.Chocolate;
import learn.patterns.decorator.decorator.Milk;
import learn.patterns.decorator.decorator.Soy;

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
