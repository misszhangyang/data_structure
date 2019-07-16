package test.stack;

import com.sun.media.sound.SoftSynthesizer;

/**
 * 使用数组模拟栈的实现 主要的方法有：数据的入栈，出栈，以及栈的遍历
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

// 使用数组实现栈的相关方法
class Stack {
	private int maxSize; // 表示的是栈的大小
	private int top = -1; // 表示的是栈顶元素的指针位置，初始值为-1
	private int[] arr; // 使用数组模拟栈

	public Stack(int maxSize) {
		this.maxSize = maxSize;
		this.arr = new int[maxSize];
	}

	// 判断是否栈满
	public boolean isFull() {
		return maxSize - 1 == top;
	}

	// 判断是否为栈空
	public boolean isNull() {
		return top == -1;
	}

	//添加数据入栈
	public void addStack(int value) {
		if (isFull()) {
			System.out.println("当前栈已满，无法添加元素--");
			return;
		}
		//将对应的指针位置加一
		top++;
		//将新增的元素添加到栈顶
		arr[top] = value;
	}
	
	//弹出栈顶元素
	public int popStack() {
		if(isNull()) {
			System.out.println("当前栈为空，无法取出元素");
		}
		//因为弹出元素的时候需要对栈顶指针进行后移操作，所以需要使用一个临时变量存储当前的栈顶元素
		int returnValue = arr[top];
		//将当前位置的指针后移
		top--;
		return returnValue;
	}
	
	//遍历当前的栈
	public void listStack() {
		if(isNull()) {
			System.out.println("当前栈为空，无法遍历");
			return;
		}
		//从栈顶元素开始遍历
		int size = top;
		for(int i = size;i >= 0; i--) {
			int value = arr[i];
			System.out.println("当前取出的是栈的第" + i + "个元素：" + value);
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
