package learn.guava;

import com.google.common.collect.*;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 11/24/2017-18:08
 */
public class NewCollection {
    @Test
    public void test() {
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.add("A");
        wordsMultiset.add("b",3);
        wordsMultiset.add("A");
        wordsMultiset.add("A");
        wordsMultiset.add("A");

        System.out.println(wordsMultiset.count("A"));
        System.out.println(wordsMultiset.count("b"));

        System.out.println(wordsMultiset);

        HashMultiset<String> hashMultiset = HashMultiset.create();

        TreeMultiset<String> treeMultiset = TreeMultiset.create();

    }

    @Test
    public void test2() {
        ListMultimap<String, String> listMultimap = ArrayListMultimap.create();


        listMultimap.put("a", "1");
        listMultimap.put("a", "2");
        listMultimap.put("b", "2");
        listMultimap.put("b", "3");

        List<String> aList = listMultimap.get("a");


    }




}
