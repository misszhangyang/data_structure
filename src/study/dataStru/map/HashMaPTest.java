package study.dataStru.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * ����java��Ŀ�м��г�����map
 * @author yang
 *
 */
public class HashMaPTest {
	
	/**
	 * ��Լ��г�����map���ϵ�����
	 * 1 �����ļ���map���ϵ�ʵ������HashMap,HashTable,TreeMap,LinkedHashMap
	 * 2 ���� 
	 *    HashMap�Ƿ�ͬ���ģ�ֵ����һ��keyΪ�գ��ظ���ֵ�Ḳ�ǣ�HashTale��������(����Ĭ�ϲ���������ֵ)
	 *    ��ֻ��ʵ�ֵķ�����������synchronized�ؼ���ʵ��ͬ������Ч��Ҫ��HashMap��
	 *    TreeMapĬ����ʵ����һ�������ܣ���������key��Ĭ����һ����С���������,Ĭ���ǲ���������ֵ��
	 *    LinkedHashMapĬ���Ǽ�¼��һ�����ݵĲ���˳��Ĭ��������ֵ
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
