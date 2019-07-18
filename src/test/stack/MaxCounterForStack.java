package test.stack;

public class MaxCounterForStack {
	public static void main(String[] args) {
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
			// 获取第一个元素
			ch1 = str.substring(index, index + 1).charAt(0);
			// 如果当前符合栈是空，则直接入栈，针对多位数字，则先进行判断再入库
			// 如果当前字符是数字，则不入栈，继续向后移动，  90 + 4*7 -9
			//如果取出来是数字，则继续向后移动，=> 指导下一位是符号，则取出第一位到最后一位
			//如果是符号，则将第一个数入栈
			if (!numStack.isChar(ch1)) {
				numIndex++;
				//如果最后一位是数字
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
					// 当前符号栈为非空，则先判断优先级,优先级比当前栈中符号小于或等于，则直接弹出数栈中的数进行计算
					if (chStack.getLevelByChar(ch1 - 48) > chStack.getLevelByChar(chStack.getFirst())) {
						chStack.addStack(ch1);
						numIndex++;
					} else {
						// 当前符号栈的符号优先级比符号栈中的优先级小，直接弹出数栈的俩个数和符号栈中的符号进行运算然后入栈
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

//使用数组实现栈的相关方法
//当使用栈实现计算器功能时，基本的方法下还需要加相关的方法

class MaxCounterStack {
	private int maxSize; // 表示的是栈的大小
	private int top = -1; // 表示的是栈顶元素的指针位置，初始值为-1
	private int[] arr; // 使用数组模拟栈

	public MaxCounterStack(int maxSize) {
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

	// 添加数据入栈
	public void addStack(int value) {
		if (isFull()) {
			System.out.println("当前栈已满，无法添加元素--");
			return;
		}
		// 将对应的指针位置加一
		top++;
		// 将新增的元素添加到栈顶
		arr[top] = value - 48;
	}

	// 判断获取的元素是数字还是符号
	public boolean isChar(int cha) {
		if (cha == '+' || cha == '-' || cha == '*' || cha == '/') {
			return true;
		} else {
			return false;
		}
	}

	// 依据传入的char获得对应的优先级
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

	// 依据传入的数和符合进行运算
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

	// 返回当前栈顶元素
	public int getFirst() {
		return arr[top];
	}

	// 弹出栈顶元素
	public int popStack() {
		if (isNull()) {
			System.out.println("当前栈为空，无法取出元素");
		}
		// 因为弹出元素的时候需要对栈顶指针进行后移操作，所以需要使用一个临时变量存储当前的栈顶元素
		int returnValue = arr[top];
		// 将当前位置的指针后移
		top--;
		return returnValue;
	}

	// 遍历当前的栈
	public void listStack() {
		if (isNull()) {
			System.out.println("当前栈为空，无法遍历");
			return;
		}
		// 从栈顶元素开始遍历
		int size = top;
		for (int i = size; i >= 0; i--) {
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


