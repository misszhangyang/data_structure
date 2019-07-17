package test.stack;

/**
 * 利用栈实现一个字符的计算功能（6+2*5-2） = 14
 * 思路分析：
 * 1 关键点，分为数栈和符号栈，当符合栈为空时，从计算字符串中取出来的符号就直接入栈
 * 2 当符号栈中非空时，需要对符号栈的的符号和入栈的符号进行优先级的比较，如果优先级比栈顶的符号高，
 * 3 则直接将符号入栈，如果优先级比栈顶符号小或则等于，则弹出当前数栈的俩个元素和符号栈的栈顶符合，直接进行运算，将运算结果入栈
 * @author yang
 *
 */
public class CounterForStack {
	
	public static void main(String[] args) {
		CounterStack numStack = new CounterStack(4);
		CounterStack chStack  = new CounterStack(4);
		String str = "2+4*5-2";
		int index = 0;
		int num1;
		int num2;
		char ch1;
		int ch2;
		int result;
		while(true) {
			//获取第一个元素
			ch1 = str.substring(index, index + 1).charAt(0);
			//如果当前符合栈是空，则直接入栈
			//如果当前字符是数字，则入库
			if(!numStack.isChar(ch1)) {
				numStack.addStack(ch1);
			}
			else {
				if(chStack.isNull()) {
					chStack.addStack(ch1);
				}else {
					//当前符号栈为非空，则先判断优先级,优先级比当前栈中符号小于或等于，则直接弹出数栈中的数进行计算
					if(chStack.getLevelByChar(ch1) > chStack.getLevelByChar(chStack.getFirst())) {
						chStack.addStack(ch1);
					}else {
						//当前符号栈的符号优先级比符号栈中的优先级小，直接弹出数栈的俩个数和符号栈中的符号进行运算然后入栈
						while(numStack.getTop() >= 1) {
							num1 = numStack.popStack();
							num2 = numStack.popStack();
							ch1 = (char) (chStack.popStack() + '0');
							numStack.setTop(numStack.counterNum(num1,num2,ch1));
							chStack.setTop(ch1);
						}
					}
				}
			}
			if(index < str.length()) {
				index ++;
			}else {
				while(numStack.getTop() >= 1) {
					num1 = numStack.popStack();
					num2 = numStack.popStack();
					ch1 = (char) (chStack.popStack() + '0');
					numStack.setTop(numStack.counterNum(num1,num2,ch1));
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

class CounterStack {
	private int maxSize; // 表示的是栈的大小
	private int top = -1; // 表示的是栈顶元素的指针位置，初始值为-1
	private int[] arr; // 使用数组模拟栈

	public CounterStack(int maxSize) {
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
		arr[top] = value - 48;
	}
	
	//判断获取的元素是数字还是符号
	public boolean isChar(int cha) {
		if(cha == '+' || cha == '-' || cha == '*' || cha == '/') {
			return true;
		}
		else {
			return false;
		}
	}
	//依据传入的char获得对应的优先级
	public int getLevelByChar(int c) {
		if(c == '*' || c == '/') {
			return 1;
		}else if(c == '+' || c == '-') {
			return 0;
		}
		else {
			return  -1;
		}
	}
	
	//依据传入的数和符合进行运算
	public int counterNum(int num1,int num2,int c) {
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
	
	//返回当前栈顶元素
	public int getFirst() {
		return arr[top];
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
