package learn.alibaba;

import java.util.Objects;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 05/31/2017-11:21
 */
public class ObjectsUtil {
    public static void main(String[] args) {
        String a = "false";
        Boolean b = false;
        if (Objects.equals(a, b)) {
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
