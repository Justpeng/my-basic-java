package learn.chapter.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Created by @Just on 2016/10/5.
 */
public class ForkJoinDemo {
    public static void main(String args[]) throws ExecutionException, InterruptedException {
        long s = 1l;
        long e = 10000000L;
        long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Long> result = forkJoinPool.submit(new FJTask(s,e));
        //System.out.println(result.get());
        forkJoinPool.shutdown();
        long mid = System.currentTimeMillis();
        int sum =0;
        for(long i=s;i<e;i++){
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("1:"+(mid-start));
        System.out.println("2:"+(end-mid));
//        1:5
//        2:31

    }
}

class FJTask extends RecursiveTask {
    static final int THRESHOLD=1000;
    private long begin,end;
    public FJTask(long begin,long end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Object compute() {
        Long sum = 0l;
        if((end-begin)<=THRESHOLD){
            for (long i = begin; i <end ; i++) {
                sum+=i;
            }
        }else{
            long mid = (end+begin)/2;
            FJTask leftF = new FJTask(begin,mid);
            leftF.fork();
            FJTask rightF = new FJTask(mid+1,end);
            rightF.fork();
            long lr = (long) leftF.join();
           // System.out.println(begin+"-"+mid+":"+lr);
            long rr = (long) rightF.join();
          //  System.out.println(mid+"-"+end+":"+rr);
            sum = lr+rr;
        }
        return sum;
    }
}

