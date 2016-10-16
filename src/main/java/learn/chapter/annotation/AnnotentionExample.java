package learn.chapter.annotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sysware.com on 2016/8/11.
 */

public class AnnotentionExample {

    /**
     * @return
     */
    @Override
    @MethodInfo(author = "lip",date="august 8 11",comments="mainmethod",revision = 1)
    public String toString(   ){
        return "Override trring";
    }

    @Deprecated
    @MethodInfo(comments = "Deprecated method" ,date="3333")
    public static void  oldMethod(   ){
         System.out.println( "old method ,don not use it");
    }

    @SuppressWarnings({"unchecked","deprecation"})
    @MethodInfo(author = "lip",date="august 8 11", comments="main method",revision = 2)
    public static void genericsTest(){
        List list = new ArrayList<>();
        list.add("abc");
        oldMethod();
    }

    public static void main(String args[]){
        genericsTest();
    }

}
