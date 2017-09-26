package learn.RateLimit;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Description: 并发
 *
 * @author peng.li(李朋 lp45959)
 * @version 1.0.0
 * @since 08/10/2017-17:49
 */
@Slf4j
public class ListenableFutrueDemo {
    @Test
    public void test() {
       // testRateLimiter();
        testListenableFutrue();
    }


    public void testRateLimiter(){
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(20));
        RateLimiter limiter = RateLimiter.create(3);//每秒不超过3个任务被提交
        for(int i=0;i<50;i++) {
            limiter.acquire();
            final ListenableFuture<Integer> listenableFuture = executorService.submit(new Task("is "+ i));
        }
    }

    public void testListenableFutrue() {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newScheduledThreadPool(20));
        final ListenableFuture<Integer> listenableFuture = executorService.submit(new Task("testListenableFuture"));
        //同步获取调用结果

//        listenableFuture.addListener(()->{
//            try {
//                System.out.println("get listenable future's result " + listenableFuture.get());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        },executorService);


        //第二种方式
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                System.out.println("get listenable future's result with callback " + result);
            }
            @Override
            public void onFailure(Throwable throwable) {

            }
        },executorService);


    }


class Task implements Callable<Integer> {
        String str;
        public Task(String str){
            this.str = str;
        }
        @Override
        public Integer call() throws Exception {
            System.out.println("call execute.." + str);
            TimeUnit.SECONDS.sleep(1);
            return 7;
        }
    }
}
