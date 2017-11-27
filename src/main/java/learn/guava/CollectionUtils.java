package learn.guava;


import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

/**
 * Description: Guava集合工具类
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 11/27/2017-14:22
 */
public class CollectionUtils {
    @Test
    public void test() {
        List<Person> list = Lists.newArrayList();

        Map<String, String> map = Maps.newHashMap();

        List<String> list2 = Lists.newArrayList("A", "b");
    }





    @Getter
    @Setter
    class Person {
        String name;
    }
}
