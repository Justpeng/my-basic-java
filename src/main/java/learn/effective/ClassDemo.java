package learn.effective;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/09/2017-11:05
 */
public class ClassDemo {
    private static final String[] PRIVATE_VALUES= {"A","b"};
    //1 可变数组为私有，使用公有可变列表
    public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    //2 返回私有数组的一个备份
    public static final String[] values() {
        return PRIVATE_VALUES.clone();
    }

}
