package learn.alibaba.thread;

import org.jetbrains.annotations.NotNull;
import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.*;

/**
 * Description:
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 05/31/2017-15:47
 */
public class ThreadDemo {

    ExecutorService executorService;

    void init() {
        executorService = new ThreadPoolExecutor(10, 100, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                return null;
            }
        });
    }

    private ThreadFactory getThreadFactory() {
//        ThreadFactory threadFactory = (r) -> r.run();


        return null;
    }

}
