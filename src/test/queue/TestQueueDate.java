package test.queue;

import java.util.Scanner;
/**
 * 测试使用数组实现队列
 * day07-07 
 * @author zhangyang
 *
 */
public class TestQueueDate {

	public static void main(String[] args) {
//		 ArrayQueue queue = new ArrayQueue(5);//初始化队列的大小为5
		CricleQueue queue = new CricleQueue(5);
	        //获取输入的数据
	        Scanner c  = new Scanner(System.in);
	        char c1 = ' ';
	        boolean loop = true;
	        while(loop){
	            System.out.println("输入a表示向当前队列中添加数据");
	            System.out.println("输入s表示向当前查看当前队列");
	            System.out.println("输入f表示向当前查看当前队列第一个元素");
	            System.out.println("输入r表示取出当前队列的头部数据");
	            System.out.println("输入e表示退出");
	            System.out.println("请输入数据：");
	            c1 =  c.next().charAt(0);
	            switch (c1){
	                case 'a':
	                    int n = new Scanner(System.in).nextInt();
	                    queue.addQueue(n);
	                    break;
	                case 'f':
	                    try{
	                       int n1 = queue.showFirstQueue();
	                       System.out.println("查看队列的第一个数是："+ n1);
	                    }catch (Exception e){
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 's':
	                    queue.viewQueue();
	                    break;
	                case 'r':
	                    int n2 = queue.getQueue();
	                    System.out.println("取出来的数据是：" + n2);
	                    break;
	                case 'e':
	                    c.close();
	                    loop = false;
	                    break;
	                default:
	                    break;
	            }

	        }
	        System.out.println("队列的查看现在已经退出啦");
	    }
	}
