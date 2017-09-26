package learn.jdk8;


import org.apache.commons.lang3.text.translate.NumericEntityUnescaper;
import org.junit.Test;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Optional;

import static org.apache.xalan.xsltc.runtime.Operators.names;

/**
 * Description: Optional
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 07/06/2017-10:41
 */
public class OptionalDemo implements Serializable{
    public static void main(String[] args) {
        Boolean value = false;
        String to =  value != null
                ? String.format("Optional[%s]", value)
                : "Optional.empty";
        System.out.println(to);
    }

    @Test
    public void test(){
        OptionEntity optionEntity = new OptionEntity("a","b");
        Optional<OptionEntity> entity = Optional.ofNullable(null);
        System.out.println(entity.orElse(optionEntity));
    }


    @Test
    public void testIsPresent() {
        Optional<Integer> optional = Optional.ofNullable(1);
        optional.ifPresent(i-> {
            if (i == 1) {
                System.out.println(++i);
            }}
        );
    }

    @Test
    public void testElseGet() {
        Optional<Integer> optional = Optional.ofNullable(null);
        System.out.println(optional.orElse(2));
    }


    @Test
    public void testElseGetLambda() {
        Optional<OptionEntity> entity = Optional.ofNullable(null);
        entity.orElseGet(()->getEntity());
    }

    private OptionEntity getEntity() {
        return new OptionEntity("other", "other");
    }

    @Test
    public void mapTest() {
        Optional<String> optional =  Optional.ofNullable("abc");
        System.out.println(optional.map(var->var.toUpperCase()).get());

    }


    public void paramTest() {
        User user = new User();
        user.setAge(2);
        user.setName("aaa");


    }

    private Boolean isValid(String param) {
        if (param == null || param.length() <= 0) {
            return false;
        }
        return true;
    }
}
