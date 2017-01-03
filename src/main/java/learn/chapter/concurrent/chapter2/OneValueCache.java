package learn.chapter.concurrent.chapter2;

import org.apache.ibatis.annotations.One;

import java.math.BigInteger;
import java.util.*;

/**
 * 在不可变容器中缓存数字和它的因数
 *
 * @author:Just
 * @create:2016-12-28 20:18
 */
public class OneValueCache {

    /**
     * 一个Map lastLogin记录每位用户的最近登录时间
     * 1 Date自身是可变的
     * 2 但，若Date在Map值中是不可变的，那么就可以忽略锁
     * 3 synchronizedMap保证并发安全
     */
    public Map<String, Date> lastLogin = Collections.synchronizedMap(new HashMap<String, Date>());


    private final BigInteger lastNumber;
    private final BigInteger[] factors;

    public OneValueCache(BigInteger number, BigInteger[] f) {
        lastNumber = number;
        factors = Arrays.copyOf(f, f.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastNumber == null || !lastNumber.equals(i)) {
            return null;
        } else {
            return Arrays.copyOf(factors, factors.length);
        }
    }
}
