package test.queue;

/**
 * 此实现是利用数组实现环形队列 day07-07
 * 此实现由于最后一个元素的real指向的是最后一个元素的下一个元素，因此预留的一个数组空间作为判断，所以无法存满
 * @author yang
 *
 */
public class CricleQueue {

	// 几个简单的算法 判断队列是否已满（real + 1） % max == front 从0开始，(real + 1) % max
	// 取出来的结果应该是队列最后一个位置指向的下一个位置，如果此时与front重合，则队列满
	// 当前队列的有效个数 （real + max - front） % max
	private int max; // 定义队列的大小
	private int front; // 定义队列的头(指向队列的第一个位置)
	private int real; // 定义队列的尾部(指向队列的最后一个位置的下一个位置)
	private int[] arr;

	public CricleQueue(int max) {
		this.max = max;
		arr = new int[this.max];
	}

	// 队列是否已经满
	public boolean isFull() {
		return (real + 1) % max == front;
	}

	// 队列是否为空
	public boolean isNull() {
		return front == real;
	}

	// 取出队列的数据(取出第一个数)
	public int getQueue() {
		if (isNull()) {
			throw new RuntimeException("当前队列为空--");
		}
		// 先将当前的第一个数赋值，然后再将front位置向后移动
		int firstValue = arr[front];
		// 这里必须考虑取模，不然会造成数据越界
		front = (front + 1) % max;
		return firstValue;
	}

	// 查看队列的头元素
	public int showFirstQueue() {
		if (isNull()) {
			throw new RuntimeException("当前队列为空，无法取出数据");
		}
		return arr[front];
	}

	// 获取当前队列的有效个数
	public int getSize() {
		return (real + max - front) % max;
	}

	// 查看当前队列的数据
	public void viewQueue() {
		if (isNull()) {
			System.out.println("当前队列为空");
			return;
		}
		// 首先取出当前队列中的有效数据个数，然后从front（头部开始遍历到尾部）
		for (int i = front; i < front + getSize(); i++) {
			System.out.printf("arr[%d] = %d\n", i % max, arr[i % max]);// 这里的i%max 是防止i在数据过大时会造成数组越界
		}
	}

	// 向队列中新增一个数
	public void addQueue(int n) {
		if (isFull()) {
			System.out.println("当前队列已满，无法添加数据");
			return;
		}
		//real是指向最后一个位置的下一个元素，所以有数据添加进来的时候直接赋值给real
		arr[real] = n;
		//此时将real后移，这里必须考虑使用取模，不然会造成数据越界
		real = (real + 1) % max;
	}
}
