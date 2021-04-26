package study.dataStru.stack;

import java.util.HashSet;

public class MaxCounterForStack {
	public static void main(String[] args) {

		HashSet hashSet = new HashSet();

		MaxCounterStack numStack = new MaxCounterStack(7);
		MaxCounterStack chStack = new MaxCounterStack(7);
		String str = "90+9+5*7-2";
		int index = 0;
		int numIndex = 0;
		int num1;
		int num2;
		char ch1;
		char ch2;
		int result;
		while (true) {
			// ��ȡ��һ��Ԫ��
			ch1 = str.substring(index, index + 1).charAt(0);
			// �����ǰ����ջ�ǿգ���ֱ����ջ����Զ�λ���֣����Ƚ����ж������
			// �����ǰ�ַ������֣�����ջ����������ƶ���  90 + 4*7 -9
			//���ȡ���������֣����������ƶ���=> ָ����һλ�Ƿ��ţ���ȡ����һλ�����һλ
			//����Ƿ��ţ��򽫵�һ������ջ
			if (!numStack.isChar(ch1)) {
				numIndex++;
				//������һλ������
				while(index == str.length() - 1) {
					numStack.addStack(ch1);
					index++;
				}
//				numStack.addStack(ch1);
			} else {
				if (chStack.isNull()) {
					ch2 = (char)((Integer.parseInt(str.substring(0, numIndex)) + '0'));
					numStack.addStack(ch2);
					chStack.addStack(ch1);
				} else {
					ch2 = str.substring(numIndex, index).charAt(0);
					numStack.addStack(ch2);
					// ��ǰ����ջΪ�ǿգ������ж����ȼ�,���ȼ��ȵ�ǰջ�з���С�ڻ���ڣ���ֱ�ӵ�����ջ�е������м���
					if (chStack.getLevelByChar(ch1 - 48) > chStack.getLevelByChar(chStack.getFirst())) {
						chStack.addStack(ch1);
						numIndex++;
					} else {
						// ��ǰ����ջ�ķ������ȼ��ȷ���ջ�е����ȼ�С��ֱ�ӵ�����ջ���������ͷ���ջ�еķ��Ž�������Ȼ����ջ
						num1 = numStack.popStack();
						num2 = numStack.popStack();
						ch2 = (char) (chStack.popStack() + '0');
						numStack.addStack((char) (numStack.counterNum(num1, num2, ch2) + '0'));
						chStack.addStack(ch1);
						numIndex++;
					}
				}
			}
			if (index < str.length()) {
				index++;
			} else {
				while (numStack.getTop() >= 1) {
					num1 = numStack.popStack();
					num2 = numStack.popStack();
					ch2 = (char) (chStack.popStack() + '0');
					numStack.addStack((char) (numStack.counterNum(num1, num2, ch2) + '0'));
				}
				result = numStack.popStack();
				break;
			}
		}
		System.out.println(str + "=" + result);
	}
}

//ʹ������ʵ��ջ����ط���
//��ʹ��ջʵ�ּ���������ʱ�������ķ����»���Ҫ����صķ���

class MaxCounterStack {
	private int maxSize; // ��ʾ����ջ�Ĵ�С
	private int top = -1; // ��ʾ����ջ��Ԫ�ص�ָ��λ�ã���ʼֵΪ-1
	private int[] arr; // ʹ������ģ��ջ

	public MaxCounterStack(int maxSize) {
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

	// ���������ջ
	public void addStack(int value) {
		if (isFull()) {
			System.out.println("��ǰջ�������޷����Ԫ��--");
			return;
		}
		// ����Ӧ��ָ��λ�ü�һ
		top++;
		// ��������Ԫ����ӵ�ջ��
		arr[top] = value - 48;
	}

	// �жϻ�ȡ��Ԫ�������ֻ��Ƿ���
	public boolean isChar(int cha) {
		if (cha == '+' || cha == '-' || cha == '*' || cha == '/') {
			return true;
		} else {
			return false;
		}
	}

	// ���ݴ����char��ö�Ӧ�����ȼ�
	public int getLevelByChar(int c) {
		char c1 = (char) (c + '0');
		if (c1 == '*' || c1 == '/') {
			return 1;
		} else if (c1 == '+' || c1 == '-') {
			return 0;
		} else {
			return -1;
		}
	}

	// ���ݴ�������ͷ��Ž�������
	public int counterNum(int num1, int num2, int c) {
		int returnValue = 0;
		switch (c) {
		case '+':
			returnValue = num1 + num2;
			break;
		case '-':
			returnValue = num2 - num1;
			break;
		case '*':
			returnValue = num1 * num2;
			break;
		case '/':
			returnValue = num2 / num1;
			break;
		default:
			break;
		}
		return returnValue;
	}

	// ���ص�ǰջ��Ԫ��
	public int getFirst() {
		return arr[top];
	}

	// ����ջ��Ԫ��
	public int popStack() {
		if (isNull()) {
			System.out.println("��ǰջΪ�գ��޷�ȡ��Ԫ��");
		}
		// ��Ϊ����Ԫ�ص�ʱ����Ҫ��ջ��ָ����к��Ʋ�����������Ҫʹ��һ����ʱ�����洢��ǰ��ջ��Ԫ��
		int returnValue = arr[top];
		// ����ǰλ�õ�ָ�����
		top--;
		return returnValue;
	}

	// ������ǰ��ջ
	public void listStack() {
		if (isNull()) {
			System.out.println("��ǰջΪ�գ��޷�����");
			return;
		}
		// ��ջ��Ԫ�ؿ�ʼ����
		int size = top;
		for (int i = size; i >= 0; i--) {
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


