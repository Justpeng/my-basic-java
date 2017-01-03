package learn.jvm.error;

import java.nio.ByteBuffer;

/**
 * @author:Just
 * 直接内存溢出
 * @create:2017-01-02 19:08
 */
public class DirectBufferOOM {
    public static void main(String args[]){
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ByteBuffer.allocateDirect(1024*1024);
            System.out.println(i);
        }

    }
}
