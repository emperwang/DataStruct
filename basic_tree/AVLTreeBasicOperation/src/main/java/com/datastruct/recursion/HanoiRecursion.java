package com.datastruct.recursion;

/**
 * 汉诺塔实现
 */
public class HanoiRecursion {

    /**
     * @param n 汉诺塔的层数
     * @param x x柱 起点柱（A）
     * @param y y柱 目标柱(B)
     * @param z z柱 中转柱(C)
     * 这里的x y  z只是起到辅助思考作用，并无实际意义
     */
    public void hannoi(int n,char x,char y,char z){
       //H(0) = 0
        if(n==0){
            // 什么也不做
        }else{
            //H(N)=H(n-1) +1 + H(n-1)
            //将n-1和圆盘从x移动到z，y为中转柱
            hannoi(n-1,x,z,y);
            //移动最大圆盘到目的柱
            System.out.println(x + "->" + y);
            //将n-1个圆盘从z移动到y，x为中转柱
            hannoi(n-1,z,y,x);
        }
    }

    /**
     *  具体的实现
     * @param n 汉诺塔层数
     * @param x 起点柱
     * @param y 目的柱
     * @param z 中转柱
     * @return
     * 这里的x y z仍是辅助思考，并无其他实际意义
     */
    public int hanoiCount(int n,char x,char y,char z){
        int moveCount = 0;
        if(n == 0){
            return 0;
        }else{
            //把n-1个盘移动到z，y作为中转柱
            moveCount += hanoiCount(n-1,x,z,y);
            //把最大的盘移动到y
            moveCount += 1;
            // 把n-1ge盘移动大y，x作为中转柱
            moveCount += hanoiCount(n-1,z,y,x);
        }
        //返回移动的次数
        return moveCount;
    }

    public static void main(String[] args) {
        HanoiRecursion hani = new HanoiRecursion();
        System.out.println(hani.hanoiCount(3,'x','y','z'));
    }
}
