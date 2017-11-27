package learn.guava;

import com.google.common.base.*;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.Test;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 11/23/2017-15:16
 */
public class BeforeLearn {

    @Test
    public void test() {
        int i = 0;
        //Preconditions.checkArgument(i > 0, "Argument was %s but expected nonnegative", i);

        int j =1;
        Preconditions.checkArgument(j < i, "Expected i > j ,but %s < %s", i, j);
    }

    @Test
    public void test2() {
        // Preconditions.checkNotNull(null, "request is null");
        String a = null;
        String optional = Optional.fromNullable(a).or("a");
        System.out.println(optional);

        Optional<Integer> possible = Optional.of(5);
        if (possible.isPresent()) {
            System.out.println(possible.get());
        }

        Preconditions.checkState(true == false, "true not equals false");

    }

    @Test
    public void test3() {
        String[] arr = new String[]{"1","2","3","4"};
        int index = 4;
        Preconditions.checkElementIndex(index, arr.length, "index is > arr.length");

        Preconditions.checkPositionIndex(3, arr.length);

        Preconditions.checkPositionIndexes(2,3,arr.length);
    }


    @Test
    public void test4() {
        System.out.println(Objects.equal(1, null));

        System.out.println(java.util.Objects.equals(2, 3));

        System.out.println(Objects.hashCode(1, 2, 3, 4, 5));
        System.out.println(java.util.Objects.hashCode(1));
    }

    @Test
    public void testToString() {
        Life life = new Life("just",2);
        System.out.println(life.toString());
    }

    @Test
    public void testOrdering() {
        Ordering<Life> byAge = new Ordering<Life>() {
            @Override
            public int compare(@Nullable Life left, @Nullable Life right) {
                return Ints.compare(left.getAge(),right.getAge());
            }
        };
        Life life = new Life("a", 2);
        Life life2 = new Life("b", 3);
        System.out.println(byAge.compare(life, life2));

        Ordering<Life> ordering = Ordering.natural().nullsLast().onResultOf(new Function<Life, Comparable>() {
            @Nullable
            @Override
            public Comparable apply(@Nullable Life input) {
                return input.name;
            }
        });
        Life life3 = new Life(null,0);
        List<Life> lifes = new ArrayList<>();
        lifes.add(life);
        lifes.add(life2);
        lifes.add(life3);

        ordering.greatestOf(lifes.listIterator(), lifes.size());
        Collections.sort(lifes,ordering );
     //   System.out.println(ordering.max(lifes.iterator()));


        Ordering<Integer> integerOrdering = new Ordering<Integer>() {
            @Override
            public int compare(@Nullable Integer left, @Nullable Integer right) {
                return Ints.compare(left,right);
            }
        };

        System.out.println(integerOrdering.min(1, 3));
    }


    @Data
    class Life implements Comparable<Life>{
        private String name;
        private Integer age;

        public Life() {

        }

        public Life(String name,Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return  MoreObjects.toStringHelper(this).add("name",this.name).add("age",this.age).addValue(3).toString();
        }

        @Override
        public int compareTo(@NotNull Life o) {
            return ComparisonChain.start().compare(this.name,o.name).compare(this.age,o.age).result();
        }
    }
}
