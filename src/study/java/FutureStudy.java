package study.java;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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

        long paraStream = System.currentTimeMillis();
        System.out.println(getPriceList("java8编程思想"));
        long paraStreamTime = System.currentTimeMillis() - paraStream;

        System.out.println("paraStream消耗的时间为：" + paraStreamTime + "毫秒");

        long futureStream = System.currentTimeMillis();
        System.out.println(getPriceList2("java9编程思想"));
        long futureStreamTime = System.currentTimeMillis() - futureStream;

        System.out.println("futureStreamTime消耗的时间为：" + futureStreamTime + "毫秒");
    }

    private static void doSomeThingElse() {
        System.out.println("-------正在做其他的事情-----");
    }


//    并行操作 Streams 和CompletableFutures 比较 
//    1. 如果有大量计算的操作而没有I/O 操作（包括连接互联网），那么使用异步的 Streams 可以得到最好的性能。
//    2. 相反如果有很多io操作， 使用 CompletableFutures可以得到更好的编弹性。
    public static List<String> getPriceList(String product){
        List<FutureStudy> futureStudies = Arrays.asList(new FutureStudy("京东商城"), new FutureStudy("天猫商城"),
                new FutureStudy("拼多多"), new FutureStudy("苏宁易购"));
        List<String> collect = futureStudies.parallelStream().map(futureStudy ->
            String.format(product + "在" + "%s 的价格是：% 2f", futureStudy.name, futureStudy.getPrice(product))).collect(Collectors.toList());
        return collect;
    }

    public static List<String> getPriceList2(String product){
        List<FutureStudy> futureStudies = Arrays.asList(new FutureStudy("京东商城"), new FutureStudy("天猫商城"),
                new FutureStudy("拼多多"), new FutureStudy("苏宁易购"));
        List<CompletableFuture<String>> collect = futureStudies.stream().map(futureStudy ->
                //使用异步的方式计算每种商品的价格
                CompletableFuture.supplyAsync(() -> product + "在" +  futureStudy.name + "的价格是" + futureStudy.getPrice(product))
        ).collect(Collectors.toList());
        return collect.stream().map(
                CompletableFuture::join).collect(Collectors.toList()); //join操作等待所有的异步结果
    }


}
