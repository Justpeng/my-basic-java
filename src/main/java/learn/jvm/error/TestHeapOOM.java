package learn.jvm.error;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:Just
 * @create:2017-01-02 12:42
 */
public class TestHeapOOM {
    static class Demo{}
    public static void main(String args[]){
        List<Demo> list = new ArrayList<Demo>();
        while(true){
            list.add(new Demo());
        }
    }
}
