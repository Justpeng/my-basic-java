package learn.arithmetic;

/**
 * 求最大公约数算法
 * Created by @Just on 2016/10/18.
 */
public class CommonDivisor {
    /**
     * 求两个数的最大公约数
     * 思路：循环累加
     * 缺点：效率低
     */
    public static int getCommonDivisor(int numberA, int numberB) {
        int largeNumber = numberA>numberB? numberA:numberB;
        int smallNumber = numberA>numberB? numberB:numberA;
        if((largeNumber%smallNumber)==0)
            return smallNumber;
        int num = 1;
        for(int i=2;i<smallNumber/2;i++){
            if (smallNumber % i == 0 && largeNumber % i == 0) {
                num = i;
            }
        }
        return num;
    }

    /**
     * 欧几里得：
     * 辗转相除法：两个正整数(a>b)，它们的最大的公约数等于a除以b的余数c,与b的最大
     * 公约数
     * 缺点：取摸运算性能比较低
     * @param numberA
     * @param numberB
     * @return
     */
    public static int getCommonDivisor1(int numberA, int numberB) {
       int i = 0;
        if(numberA>numberB){
            i = getDC(numberA,numberB);
        }else{
            i = getDC(numberB,numberA);
        }
        return i;
    }

    /**
     * 算数九章：更相减损术
     * 两个正整数a和b(a>b),它们的最大公约数等于a-b的差值c和较小数b的最大公约数
     */
    public static int getCommonDivisor2(int numberA, int numberB) {
        if (numberA == numberB) {
            return numberB;
        } else if (numberA > numberB) {
            return getDC(numberB, numberA - numberB);
        } else {
            return getDC(numberA, numberB - numberA);
        }
    }
            //取摸
    public static int getDC(int a,int b){
        if(a%b==0){
            return b;
        }else {
            return getDC(b,a%b);
        }
    }

    public static int getCommonDivisor3(int numberA, int numberB) {
        if(numberA==numberB){
            return numberB;
        }else if(numberA>numberB){
            return getDC3(numberB,numberA-numberB);
        }else{
            return getDC3(numberA,numberB-numberA);
        }
    }

    //更相减损加位移运算
    public  static int getDC3(int a,int b){
        if(a==b) return b;
        if(a<b){
            return getDC3(b,a);
        }else{
            if(a%b==0){
                return  b;
            } else {
                //和1做运算判断奇偶
                int i = a & 1;
                int j = b & 1;
                if (i == 0 && j == 0) {
                    return getDC3(a >> 1, b >> 1) << 1;
                } else if (i == 0 && j != 0) {
                    return getDC3(a >> 1, b);
                } else if (i != 0 && j == 0) {
                    return getDC3(a, b >> 1);
                } else {
                    return getDC3(b, a - b);
                }
            }
        }

    }

    public static int getCommonDivisor4(int numberA, int numberB) {
        if(numberA==numberB){
            return numberB;
        }else if(numberA>numberB){
            return getDC4(numberB,numberA-numberB);
        }else{
            return getDC4(numberA,numberB-numberA);
        }
    }


    /**
     * 若结果为x
     * 两个数都是偶数 如 a = 100;b = 4
     * 第一次 a-b=96 也为偶数，则均右移一位，并在结果 >>  x = 2
     * 递归结果为 a =48 b =2，同样为偶数，则均右移一位，结果 >>  x =2*2
     * 此时a=24,b=1,其实此时已可知结果为 x = 4，但根据算法，需要判断至a=b，即a和b均
     * 右移为1时才会返回，假若a是10000000呢?显然存在缺点
     * @param a
     * @param b
     * @return
     */
    public  static int getDC4(int a,int b){
        if(a==b) return b;
        if(a<b){
            return getDC4(b,a);
        }else {
                //和1做运算判断奇偶
                int i = a & 1;
                int j = b & 1;
                if (i == 0 && j == 0) {
                    return getDC4(a >> 1, b >> 1) << 1;
                } else if (i == 0 && j != 0) {
                    return getDC4(a >> 1, b);
                } else if (i != 0 && j == 0) {
                    return getDC4(a, b >> 1);
                } else {
                    return getDC4(b, a - b);
                }
            }
    }







    public static void main(String args[]) throws InterruptedException {

//        Random random = new Random();
//
//        int len  =1000;
//        for(int i=0;i<100;i++){
//            int a =4;
//            int b = 100;
//            System.out.println("a:"+a+" b:"+b);
//
//            int first = getCommonDivisor(a, b);
//            int second = getCommonDivisor1(a, b);
//            int third = getCommonDivisor2(a, b);
//            int forth = getCommonDivisor3(a, b);
//
//            System.out.println("first:"+first);
//            System.out.println("second:"+second);
//            System.out.println("third:"+third);
//            System.out.println("forth:"+forth);
//
//            TimeUnit.SECONDS.sleep(3);
//        }

        int a = 1000000000,b=4;
        long date = System.currentTimeMillis();
        int j = getCommonDivisor3(a,b);

        System.out.println("j:"+j+" time1:"+String.valueOf(System.currentTimeMillis()-date));
        long date2 = System.currentTimeMillis();
        int j1 = getCommonDivisor4(a,b);
        System.out.println("j1:"+j1+" time1:"+String.valueOf(System.currentTimeMillis()-date2));



    }



}
