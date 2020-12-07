package study.dataStru.queue;

/**
 * ��ʵ������������ʵ�ֻ��ζ��� day07-07
 * ��ʵ���������һ��Ԫ�ص�realָ��������һ��Ԫ�ص���һ��Ԫ�أ����Ԥ����һ������ռ���Ϊ�жϣ������޷�����
 * @author yang
 *
 */
public class CricleQueue {

	// �����򵥵��㷨 �ж϶����Ƿ�������real + 1�� % max == front ��0��ʼ��(real + 1) % max
	// ȡ�����Ľ��Ӧ���Ƕ������һ��λ��ָ�����һ��λ�ã������ʱ��front�غϣ��������
	// ��ǰ���е���Ч���� ��real + max - front�� % max
	private int max; // ������еĴ�С
	private int front; // ������е�ͷ(ָ����еĵ�һ��λ��)
	private int real; // ������е�β��(ָ����е����һ��λ�õ���һ��λ��)
	private int[] arr;

	public CricleQueue(int max) {
		this.max = max;
		arr = new int[this.max];
	}

	// �����Ƿ��Ѿ���
	public boolean isFull() {
		return (real + 1) % max == front;
	}

	// �����Ƿ�Ϊ��
	public boolean isNull() {
		return front == real;
	}

	// ȡ�����е�����(ȡ����һ����)
	public int getQueue() {
		if (isNull()) {
			throw new RuntimeException("��ǰ����Ϊ��--");
		}
		// �Ƚ���ǰ�ĵ�һ������ֵ��Ȼ���ٽ�frontλ������ƶ�
		int firstValue = arr[front];
		// ������뿼��ȡģ����Ȼ���������Խ��
		front = (front + 1) % max;
		return firstValue;
	}

	// �鿴���е�ͷԪ��
	public int showFirstQueue() {
		if (isNull()) {
			throw new RuntimeException("��ǰ����Ϊ�գ��޷�ȡ������");
		}
		return arr[front];
	}

	// ��ȡ��ǰ���е���Ч����
	public int getSize() {
		return (real + max - front) % max;
	}

	// �鿴��ǰ���е�����
	public void viewQueue() {
		if (isNull()) {
			System.out.println("��ǰ����Ϊ��");
			return;
		}
		// ����ȡ����ǰ�����е���Ч���ݸ�����Ȼ���front��ͷ����ʼ������β����
		for (int i = front; i < front + getSize(); i++) {
			System.out.printf("arr[%d] = %d\n", i % max, arr[i % max]);// �����i%max �Ƿ�ֹi�����ݹ���ʱ���������Խ��
		}
	}

	// �����������һ����
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("��ǰ�����������޷��������");
			return;
		}
		//real��ָ�����һ��λ�õ���һ��Ԫ�أ�������������ӽ�����ʱ��ֱ�Ӹ�ֵ��real
		arr[real] = n;
		//��ʱ��real���ƣ�������뿼��ʹ��ȡģ����Ȼ���������Խ��
		real = (real + 1) % max;
	}
}
