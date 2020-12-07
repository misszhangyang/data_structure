package study.dataStru.queue;

import java.util.Scanner;
/**
 * ����ʹ������ʵ�ֶ���
 * day07-07 
 * @author zhangyang
 *
 */
public class TestQueueDate {

	public static void main(String[] args) {
//		 ArrayQueue queue = new ArrayQueue(5);//��ʼ�����еĴ�СΪ5
		CricleQueue queue = new CricleQueue(5);
	        //��ȡ���������
	        Scanner c  = new Scanner(System.in);
	        char c1 = ' ';
	        boolean loop = true;
	        while(loop){
	            System.out.println("����a��ʾ��ǰ�������������");
	            System.out.println("����s��ʾ��ǰ�鿴��ǰ����");
	            System.out.println("����f��ʾ��ǰ�鿴��ǰ���е�һ��Ԫ��");
	            System.out.println("����r��ʾȡ����ǰ���е�ͷ������");
	            System.out.println("����e��ʾ�˳�");
	            System.out.println("���������ݣ�");
	            c1 =  c.next().charAt(0);
	            switch (c1){
	                case 'a':
	                    int n = new Scanner(System.in).nextInt();
	                    queue.addQueue(n);
	                    break;
	                case 'f':
	                    try{
	                       int n1 = queue.showFirstQueue();
	                       System.out.println("�鿴���еĵ�һ�����ǣ�"+ n1);
	                    }catch (Exception e){
	                        System.out.println(e.getMessage());
	                    }
	                    break;
	                case 's':
	                    queue.viewQueue();
	                    break;
	                case 'r':
	                    int n2 = queue.getQueue();
	                    System.out.println("ȡ�����������ǣ�" + n2);
	                    break;
	                case 'e':
	                    c.close();
	                    loop = false;
	                    break;
	                default:
	                    break;
	            }

	        }
	        System.out.println("���еĲ鿴�����Ѿ��˳���");
	    }
	}
