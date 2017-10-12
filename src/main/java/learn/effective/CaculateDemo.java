package learn.effective;

import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 09/30/2017-11:26
 */
public class CaculateDemo {
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        Long sum=0L;
        for(long i=0;i< Integer.MAX_VALUE;i++) {
            sum+=i;
        }
        System.out.println("Long sum耗时："+(System.currentTimeMillis()-start));

        long start2 = System.currentTimeMillis();
        long sum2=0L;
        for(long i=0;i< Integer.MAX_VALUE;i++) {
            sum2+=i;
        }
        System.out.println("long sum耗时："+(System.currentTimeMillis()-start2));
    }
}
