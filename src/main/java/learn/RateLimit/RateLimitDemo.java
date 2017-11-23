package learn.RateLimit;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Description: guava令牌桶算法
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 08/10/2017-14:51
 */
public class RateLimitDemo {

    public static void main(String[] args) {

        testNoRateLimit();
        testWithRateLimiter();

    }

    public static void testNoRateLimit() {
        long start = System.currentTimeMillis();
        for(int i=0;i<30;i++) {
            System.out.println("Call execute.."+i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end -start);
    }

    public static void testWithRateLimiter() {
        long start = System.currentTimeMillis();
        RateLimiter limiter = RateLimiter.create(1);
        limiter.setRate(3);
        for(int i=0;i<30;i++) {
            limiter.acquire();
            System.out.println("Call ithRateLimiter execute.."+i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end -start);
    }
}
