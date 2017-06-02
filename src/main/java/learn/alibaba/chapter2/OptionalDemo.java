package learn.alibaba.chapter2;


import java.nio.channels.Pipe;
import java.util.*;
import java.util.logging.SocketHandler;
import java.util.stream.Stream;

/**
 * Description: 空指针类
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 05/25/2017-11:33
 */
public class OptionalDemo {
    public static void main(String[] args) {

//        Map<String, Object> map = new HashMap<>();
//        map.put("name", "just");
//        map.put("age", 1);
//
//        Optional<Object> name = Optional.ofNullable(map.get("name"));
//        Optional<Object> age = Optional.of(map.get("age"));
//
//        if (name.isPresent()) {
//            System.out.println(name.get());
//        } else {
//            System.out.println("name is empty");
//        }
//        System.out.println(age.get());


        List<String> cityList = new ArrayList<>();

        cityList.add("SHA");
        cityList.add("HKG");
        Optional<List<String>> opList = Optional.ofNullable(cityList);



//        opList.l

//        Stream<String> names = Stream.of("Lamurudu", "Okanbi", "Oduduwa");
//
//        Optional<String> longest = names
//
//                .filter(name -> name.startsWith("L"))
//
//                .findFirst();
//
//        longest.ifPresent(name -> {
//
//            String s = name.toUpperCase();
//
//            System.out.println("The longest name is "+ s);
//
//        });

    }



}
