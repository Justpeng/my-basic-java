package learn.alibaba;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * Description: Map遍历
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 05/31/2017-14:47
 */
public class MapForeachDemo<K,V> {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "a");
        map.put("key2", "b");
        map.forEach((k,v)-> System.out.println("方法一#"+k +":"+v));

        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println("不用lambda:" +s +":"+ s2);
            }
        });

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("方法二#"  +  entry.getKey()+":"+entry.getValue());
        }



    }
}
