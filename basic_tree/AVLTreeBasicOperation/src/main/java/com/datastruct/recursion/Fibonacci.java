package com.datastruct.recursion;

import java.math.BigInteger;

/**
 * 斐波那契数列实现
 */
public class Fibonacci {

    /** 递归实现1:
     * 斐波那契数列实现:
     * 0,1,1,2,3,5,8,13....
     */
    public long fibonacci(int day){
        if (day == 0) {
            return 0;
        }else if(day == 1 || day == 2){
            return 1;
        }else{
            return fibonacci(day-1)+fibonacci(day-2);
        }
    }

    /**递归实现2:
     * 另一种实现
     */
    public long fib(int day){
        return day==0?0:(day==1||day==2?1:fib(day-1)+fib(day-2));
    }

    /**
     * 使用递推实现
     * @param n
     * @return
     */
    public BigInteger fibonacciN(int n){
        if(n==1){
            return new BigInteger("0");
        }
        //f(0)=0
        BigInteger n1 = new BigInteger("0");
        //f(1)=1
        BigInteger n2 = new BigInteger("1");
        BigInteger sn = new BigInteger("0");

        for(int i=0;i<n-1;i++){
            sn = n1.add(n2);
            n1 = n2;
            n2 = sn;
        }
        return sn;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        long now = System.currentTimeMillis();
        //System.out.println("第11天动物数量为:"+fibonacci.fibonacci(11));
        //System.out.println("第500天动物数量为:"+fibonacci.fibonacci(500));
        //System.out.println("第11天动物数量为:"+fibonacci.fibonacciN(11));
        System.out.println("第500天动物数量为:"+fibonacci.fibonacciN(500));
        System.out.println("time:"+(System.currentTimeMillis()-now));
    }
}

