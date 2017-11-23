package learn.jdk8;

import com.beust.jcommander.internal.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Description: jdk8Stream
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 07/07/2017-14:13
 */
public class StreamDemo {
    @Test
    public void test() {
        List<Integer> nums =  Lists.newArrayList(1, null, 3, 4, null);
        System.out.println(        nums.stream().filter(num -> num != null).count());
    }
}
