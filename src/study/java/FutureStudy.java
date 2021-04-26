package study.java;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @program: data_structure
 * @description: Future学习demo
 * @author: Mr.ZhangYang
 * @create: 2021-04-26 10:48
 **/
public class FutureStudy {

    private String name;

    private Random random = new Random();

    public FutureStudy(String name){
        this.name = name;
    }

    /**
     * 模拟延迟
     **/
    public static  void delay() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1);
    }

    /**
     * 模拟获取价格
     * @param product 产品类型
     * @return        价格
     */
    public double getPrice(String product){
        return calculatePrice(product);
    }

    /**
     * 实时计算价格
     * @param product  产品类型
     * @return         返回价格
     */
    private double calculatePrice(String product) {
        try{
            delay();
        }catch (Exception e){
            System.out.println("线程休眠出现错误"+ e);
        }
        return  random.nextDouble() * product.charAt( 0) + product.charAt( 1);
    }

    /**
     * 异步获取价格
     * @param produce  产品类型
     * @return         completableFuture价格类型
     */
    public Future<Double> getPriceAsync(String produce){
        CompletableFuture<Double> completableFuture = new CompletableFuture<>();
        new Thread(() -> {
            double price = calculatePrice(produce);
            completableFuture.complete(price);
        }).start();
        return completableFuture;
    }

    public static void main(String[] args) {
        FutureStudy futureStudy = new FutureStudy("FutureStudy");
        long start = System.currentTimeMillis();
        Future<Double> testFuture = futureStudy.getPriceAsync("testFuture");
        long firstConsumerTime = System.currentTimeMillis() - start;
        System.out.println("异步获取价格消耗的时间：" + firstConsumerTime + "毫秒");

        doSomeThingElse();

        try{
            Double aDouble = testFuture.get();
        }catch (Exception e){
            System.out.println("获取异步消息出错" + e);
        }
        long start1 = System.currentTimeMillis()- start;
        System.out.println("返回价格消耗的时间是：" + start1 + "毫秒");
    }

    private static void doSomeThingElse() {
        System.out.println("-------正在做其他的事情-----");
    }


}
