package learn.chapter.annotation;

import java.lang.annotation.*;

/**
 * Created by sysware.com on 2016/8/11.
 */
@Target(ElementType.METHOD)
@Documented
@Inherited
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "lip";
    String date();
    int revision() default 1;
    String comments();
}
