package study.dataStru.stack;

/**
 * ʹ������ģ��ջ��ʵ�� ��Ҫ�ķ����У����ݵ���ջ����ջ���Լ�ջ�ı���
 * day 07-16
 * @author yang
 *
 */
public class ArrayStack {
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.addStack(3);
		stack.addStack(4);
		stack.addStack(5);
		stack.addStack(6);
		stack.addStack(7);
		
		stack.listStack();
		
		System.out.println(stack.popStack());
		
		stack.listStack();

	}

}

// ʹ������ʵ��ջ����ط���
class Stack {
	private int maxSize; // ��ʾ����ջ�Ĵ�С
	private int top = -1; // ��ʾ����ջ��Ԫ�ص�ָ��λ�ã���ʼֵΪ-1
	private int[] arr; // ʹ������ģ��ջ

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
	}

	// �ж��Ƿ�ջ��
	public boolean isFull() {
		return maxSize - 1 == top;
	}

	// �ж��Ƿ�Ϊջ��
	public boolean isNull() {
		return top == -1;
	}

	//���������ջ
	public void addStack(int value) {
		if (isFull()) {
			System.out.println("��ǰջ�������޷����Ԫ��--");
			return;
		}
		//����Ӧ��ָ��λ�ü�һ
		top++;
		//��������Ԫ����ӵ�ջ��
		arr[top] = value;
	}
	
	//����ջ��Ԫ��
	public int popStack() {
		if(isNull()) {
			System.out.println("��ǰջΪ�գ��޷�ȡ��Ԫ��");
		}
		//��Ϊ����Ԫ�ص�ʱ����Ҫ��ջ��ָ����к��Ʋ�����������Ҫʹ��һ����ʱ�����洢��ǰ��ջ��Ԫ��
		int returnValue = arr[top];
		//����ǰλ�õ�ָ�����
		top--;
		return returnValue;
	}
	
	//������ǰ��ջ
	public void listStack() {
		if(isNull()) {
			System.out.println("��ǰջΪ�գ��޷�����");
			return;
		}
		//��ջ��Ԫ�ؿ�ʼ����
		int size = top;
		for(int i = size;i >= 0; i--) {
			int value = arr[i];
			System.out.println("��ǰȡ������ջ�ĵ�" + i + "��Ԫ�أ�" + value);
		}
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

}
