package learn.alibaba.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 10/19/2017-16:00
 */
public class ListDemoTest {
    @Test
    public void testListToArray() {
        List<String> list = new ArrayList<>(3);
        long limit = 3;
        for (int i = 0; i < limit; i++){
            list.add(String.valueOf(i));
        }
        String[] arr = new String[list.size()];
        arr = list.toArray(arr);
    }
    @Test
    public void testListToArray2() {
        List<String> list = new ArrayList<>();
        int limit = 100000;
        for (int i = 0; i < limit; i++){
            list.add(String.valueOf(i));
        }
        String[] arr = list.toArray(new String[0]);
        System.out.println(arr.length);
    }


    public void testArrayToList() {
        String[] arr = new String[10];
        arr[0] = "1";
        arr[2] = "2";
        arr[3] = "3";
        List<String> list = Arrays.asList(arr);

    }



}
