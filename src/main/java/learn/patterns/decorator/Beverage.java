package learn.patterns.decorator;

import lombok.Data;

/**
 * Description: 饮料
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 06/06/2017-18:11
 */
@Data
public abstract class Beverage {
    String description="unknown Beverate";//描述

    abstract double cost();
}
