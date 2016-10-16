package learn.chapter.concurrent;

import java.util.concurrent.*;

/**
 * Created by @Just on 2016/10/5.
 */
public class ExecutorDemo {

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        //初始化具有两个固定线程的线程池
        ExecutorService es = Executors.newFixedThreadPool(3);
        //通过submit方法调用call方法；即放入线程中执行
        Future<Integer> f1 =es.submit(new Method(1,100));
        Future<Integer> f2 = es.submit(new Method(100, 1000));
        Future<Integer> f3 = es.submit(new Method(100, 1000));
        System.out.println("f1:"+f1.get());//获取返回值
        System.out.println("f2:"+f2.get());
        System.out.println("f2:"+f3.get());
        //停止执行器
        es.shutdown();
    }
}

class Method implements Callable<Integer> {
    private int begin;
    private int end;
    public Method(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = begin; i <end; i++) {
            sum+=i;
        }
        Thread.sleep(3000);
        return sum;
    }
}
