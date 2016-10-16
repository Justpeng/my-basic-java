package learn.chapter.test;

import chapter.JVMode.VolatielFeaturesExample;

/**
 * Created by sysware.com on 2016/8/19.
 */
public class Test extends  Thread{

    public void run(){


            VolatielFeaturesExample.set(2L);
            VolatielFeaturesExample.getAndIncrement();
            long r = VolatielFeaturesExample.get();
            System.out.println("- - - - lip - - - - r值=" + r + ",当前类=TestThread.run()");

    }
    public static void main(String args[]){


        new Test().start();
        new Test().start();
        new Test().start();
        new Test().start();
        new Test().start();



    }



}
