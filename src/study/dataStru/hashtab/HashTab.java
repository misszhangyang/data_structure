package study.dataStru.hashtab;

import java.util.Scanner;

/**
 * 1006ѧϰ����ʵ��hash�� Emp��ΪԱ���ĵ�����Ϣ��Ϊ�����һ���ڵ� EmpLinkedList��Ϊ�洢��������
 * ArrayEmpLinked��ΪHashTab�洢�����ϵ����� * @author yang
 *
 */
public class HashTab {

	public static void main(String[] args) {
		HashTab hashTab = new HashTab(7);
		String str = "";
		while (true) {
			System.out.println("add��ʾ���");
			System.out.println("list��ʾչʾ��ǰ�б�");
			System.out.println("sel��ʾ��ѯ��ǰ����");
			System.out.println("exit��ʾ�˳�");
			Scanner scanner = new Scanner(System.in);
			str = scanner.next();
			switch (str) {
			case "add":
				System.out.println("��������ӵ�id");
				int id = scanner.nextInt();
				System.out.println("�������Ӧ��name");
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
				System.out.println("�����������ѯ�ĵڼ�������");
				int id1 = scanner.nextInt();
				if(id1 > hashTab.size) {
					System.out.println("�������������ǰ������������޷���ѯ");
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
	 * ����ӵ�id�����Ӧ����һ�������ϣ��������һ��ȡĪ����
	 * 
	 * @param n
	 * @return
	 */
	public int delivery(int n) {
		return n % size;
	}

}

class EmpLinkedList {
	// ����һ��ͷ�ڵ�
	private Emp head;
	private int id;
	private String name;
	private int n;

	public EmpLinkedList(int n) {
		this.n = n;
	}

	/**
	 * ��ǰ���������һ��Emp
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
	 * ������ǰ����
	 */
	public void listEmp() {
		if (head == null) {
			System.out.println("-----��ǰ " + this.n + " ������ϢΪ��----");
			return;
		}
		Emp curEmp = head;
		while (true) {
			if (curEmp == null) {
				break;
			}
			System.out.printf("��ǰ�ǵ�" + this.n + "���������Ϣ��" + curEmp.id + " , " + curEmp.name);
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
	public Emp next;// ָ����һ�ڵ��ָ��

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
