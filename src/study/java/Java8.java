package study.java;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @program: data_structure
 * @description: java8新特性学习
 * @author: Mr.ZhangYang
 * @create: 2021-02-07 10:18
 * 1
 **/
public class Java8 {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        //简单对list进行排序
        names.sort((a,b) -> a.compareTo(b));
        names.forEach(item -> {
            System.out.println(item);
        });
        //使用stream对list进行过滤
        names.stream().filter(item -> item.startsWith("m")).forEach(item1 -> {System.out.println(item1);});
        //使用stream对list进行排序
        names.stream().sorted().forEach(item -> System.out.println(item));

        E a = new E("小A",12);

        E b = new E("小B",23);

        E c = new E("小C",14);

        E d = new E("小D",17);

        List<E> es = Arrays.asList(a,b,c,d);

        System.out.println("----------------使用stream的sored排序-------------------------");


        es.stream().sorted((item1,item2) ->
                item1.age - item2.age).forEach(item ->{
            System.out.println(item);
        });

        System.out.println("----------------使用正常的sored排序-------------------------");

        es.sort((item3,item2) -> item3.age - item2.age);
        es.forEach(i -> {
            System.out.println(i.age + ":" + i.name);
        });


        int max = 1000000;
        List<String> values = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }

        //串行排序 stream
        //并行排序 parallelStream
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(count);

        long t1 = System.nanoTime();

        long millis = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));


        Map<Integer,String> map = new HashMap<Integer, String>();
        map.putIfAbsent();
    }



    static class E {
        private String name;
        private int age;

        E(String name,int age){
            this.name = name;
            this.age = age;
        }
    }
}
