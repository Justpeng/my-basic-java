package learn.jvm.error;

/**
 * @author:Just
 * @create:2017-01-02 19:53
 */
public class StackOverflow {
    private int i=1;
    public void stackLeak(){
        i++;
        stackLeak();
    }
    public static void main(String args[]){
        StackOverflow stackOverflow = new StackOverflow();
        try{
            stackOverflow.stackLeak();
        }catch (Throwable e){
            System.out.println(stackOverflow.i);
            throw e;
        }
    }
}
