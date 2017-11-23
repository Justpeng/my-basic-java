package learn.effective.four;

import org.junit.Test;
import org.testng.Assert;

import java.util.*;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/23/2017-10:49
 */
public class SetTest {
    @Test
    public void test() {
        Set<String> cityCode = new HashSet<>();
        InstrumentedSet set = new InstrumentedSet(cityCode);
        set.add("sha");
        set.add("hkg");
        Assert.assertEquals(set.getAccount(),2);

        Set<String> cityCode2 = new HashSet<>();
        cityCode2.add("bjs");
        cityCode2.add("bkk");
        set.addAll(cityCode2);
        Assert.assertEquals(set.getAccount(),4);
    }
}
