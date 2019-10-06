package test.hashtab;

import java.util.Scanner;

/**
 * 1006学习代码实现hash表 Emp作为员工的单个信息作为链表的一个节点 EmpLinkedList作为存储结点的链表
 * ArrayEmpLinked作为HashTab存储数组上的链表 * @author yang
 *
 */
public class HashTab {

	public static void main(String[] args) {
		HashTab hashTab = new HashTab(7);
		String str = "";
		while (true) {
			System.out.println("add表示添加");
			System.out.println("list表示展示当前列表");
			System.out.println("sel表示查询当前链表");
			System.out.println("exit表示退出");
			Scanner scanner = new Scanner(System.in);
			str = scanner.next();
			switch (str) {
			case "add":
				System.out.println("请输入添加的id");
				int id = scanner.nextInt();
				System.out.println("请输入对应的name");
				String str1 = scanner.next();
				Emp emp = new Emp(id, str1);
				EmpLinkedList empLinkedList = hashTab.empLinkedList[hashTab.delivery(id)];
				empLinkedList.addEmp(emp);
				break;
			case "list":
				for (EmpLinkedList list : hashTab.empLinkedList) {
					list.listEmp();
				}
				break;
			case "sel":
				System.out.println("请输入你想查询的第几条链表");
				int id1 = scanner.nextInt();
				if(id1 > hashTab.size) {
					System.out.println("输入的数超过当前链表的条数，无法查询");
					break;
				}
				for(EmpLinkedList list : hashTab.empLinkedList) {
					if(list.getN() == id1) {
						list.listEmp();
					}
				}
				break;
			case "exit":
				System.exit(0);
				break;
			default:
				break;
			}
		}

	}

	private EmpLinkedList[] empLinkedList;
	private int size;

	public HashTab(int size) {
		this.size = size;
		empLinkedList = new EmpLinkedList[size];
		for (int i = 0; i < size; i++) {
			empLinkedList[i] = new EmpLinkedList(i);
		}
	}

	/**
	 * 对添加的id放入对应的那一条链表上，这里进行一个取莫运算
	 * 
	 * @param n
	 * @return
	 */
	public int delivery(int n) {
		return n % size;
	}

}

class EmpLinkedList {
	// 定义一个头节点
	private Emp head;
	private int id;
	private String name;
	private int n;

	public EmpLinkedList(int n) {
		this.n = n;
	}

	/**
	 * 向当前链表中添加一个Emp
	 * 
	 * @param id
	 * @param name
	 */
	public void addEmp(Emp emp) {
		if (head == null) {
			head = emp;
			return;
		}
		Emp curEmp = head;
		while (true) {
			if (curEmp.next == null) {
				curEmp.next = emp;
				break;
			}
			curEmp = curEmp.next;
		}
	}

	/**
	 * 遍历当前链表
	 */
	public void listEmp() {
		if (head == null) {
			System.out.println("-----当前 " + this.n + " 链表信息为空----");
			return;
		}
		Emp curEmp = head;
		while (true) {
			if (curEmp == null) {
				break;
			}
			System.out.printf("当前是第" + this.n + "条链表的信息是" + curEmp.id + " , " + curEmp.name);
			curEmp = curEmp.next;
		}
		System.out.println();
	}
	
	public int getN() {
		return this.n;
	}

}

class Emp {
	public int id;
	public String name;
	public Emp next;// 指向下一节点的指针

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
