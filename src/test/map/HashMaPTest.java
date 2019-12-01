package test.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 介绍java项目中集中常见的map
 * @author yang
 *
 */
public class HashMaPTest {
	
	/**
	 * 针对集中常见的map集合的区别
	 * 1 常见的集中map集合的实现类有HashMap,HashTable,TreeMap,LinkedHashMap
	 * 2 区别： 
	 *    HashMap是非同步的，值允许一个key为空，重复的值会覆盖，HashTale余它类似(但是默认不允许插入空值)
	 *    ，只是实现的方法中新增了synchronized关键字实现同步所以效率要比HashMap低
	 *    TreeMap默认是实现了一个排序功能，在新增的key中默认了一个从小到大的排序,默认是不允许插入空值的
	 *    LinkedHashMap默认是记录了一个数据的插入顺序，默认允许插空值
	 * @param args
	 */
    public static void main(String[] args){
        Map<Integer,Object> linkedHashMap = new TreeMap<>();
        linkedHashMap.put(2,"1qwewq");
        linkedHashMap.put(13,"2qwewq");
        linkedHashMap.put(5,"3qwewq");
        linkedHashMap.put(16,"4qwewq");
        linkedHashMap.put(8,"5qwewq");

        for(Integer obj : linkedHashMap.keySet()){
            System.out.println(obj);
        }

        System.out.println("----------------");

        for(Map.Entry<Integer,Object> obj : linkedHashMap.entrySet()){
            System.out.println(obj.getValue());
        }

    }

}
