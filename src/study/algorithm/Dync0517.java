package study.algorithm;

/**
 * @program: data_structure
 * @description: 斐波那契数列学习
 * @author: Mr.ZhangYang
 * @create: 2021-05-07 11:00
 **/
public class Dync0517 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(getSumTotal(30));
        long cun = System.currentTimeMillis()- start;
        System.out.println("耗费时间:" + cun + "毫秒");
    }

    /**
     * 递归调用
     * @param n
     * @return
     */
    public static int getSum(int n) {
        if (n == 1 || n ==2) {
            return 1;
        }
        return getSum(n - 1) + getSum(n-2);
    }

    /**
     * 使用变量值代替递归调用的重复计算问题
     * @param n
     * @return
     */
    public static int getSumTotal(int n){
        if( n == 1 || n == 2) return 1;
        int curr = 1,pre = 1;
        int sum = 0;
        for(int i = 2; i < n; i ++){
            sum = curr + pre;
            pre = curr;
            curr = sum;
        }
        return sum;
    }


}
