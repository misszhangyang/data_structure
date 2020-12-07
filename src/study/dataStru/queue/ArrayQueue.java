package study.dataStru.queue;

/**
 * ���еļ�ʵ��
 * @author yang
 *
 */
public class ArrayQueue {
	    private int max;        //������еĴ�С
	    private int front;  
	    //������е�ͷ��ָ����е�ͷ��ǰһ��λ�ã�
	    private int real;       //������е�β��
	    private int[] arr;

	    public ArrayQueue(int max){
	        this.max = max;
	        arr = new int[this.max];
	        front = -1;
	        real = -1;
	    }

	    //�����Ƿ��Ѿ���
	    public boolean isFull(){
	        return real == max - 1;
	    }

	    //�����Ƿ�Ϊ��
	    public boolean isNull(){
	        return front == real;
	    }

	    //ȡ�����е�����
	    public int getQueue(){
	        if (isNull()){
	            System.out.println("��ǰ����Ϊ��--");
	        }
	        front ++;
	        return  arr[front];
	    }

	    //�鿴���е�ͷԪ��
	    public int  showFirstQueue(){
	        if(isNull()){
	            throw new RuntimeException("��ǰ����Ϊ�գ��޷�ȡ������");
	        }
	        return arr[++front];
	    }

	    //�鿴��ǰ���е�����
	    public void viewQueue(){
	        if(isNull()){
	            System.out.println("��ǰ����Ϊ��");
	        }
	        for(int i = 0; i < arr.length;i++){
	            System.out.printf("arr[%d] = %d\n",i,arr[i]);
	        }
	    }

	    //�����������һ����
	    public void addQueue(int n){
	        if(isFull()){
	            System.out.println("��ǰ�����������޷��������");
	        }
	        real ++;
	        arr[real] = n;
	    }
}
