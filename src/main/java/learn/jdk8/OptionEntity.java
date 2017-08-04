package learn.jdk8;

import lombok.Data;

/**
 * Description: op
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 07/06/2017-15:49
 */
@Data
public class OptionEntity {
    private String name;
    private String pass;

    public OptionEntity(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }
}
