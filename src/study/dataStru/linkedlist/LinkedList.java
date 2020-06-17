package study.dataStru.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

/**
 * �������ʵ�� day07-09
 * 
 * @author yang
 *
 */
public class LinkedList {
	public static void main(String[] args) {

//		Node node1 = new Node(1, "���", "lihao");
//		Node node2 = new Node(2, "��Ħ", "xiaomo");
//		Node node3 = new Node(3, "����", "zhangmi");
//		Node node4 = new Node(4, "����", "xiaofen");
//		Node newNode = new Node(4, "�����˲�", "tianlongbabu");
//
//		SingleLinkedList singleLinkedList = new SingleLinkedList();
//		// singleLinkedList.add(node1);
//		// singleLinkedList.add(node2);
//		// singleLinkedList.add(node4);
//		// singleLinkedList.add(node3);
//
//		singleLinkedList.addBySquence(node1);
//		singleLinkedList.addBySquence(node2);
//		singleLinkedList.addBySquence(node4);
//		singleLinkedList.addBySquence(node3);
//		singleLinkedList.addBySquence(node3);
//
//		singleLinkedList.traverse();
//
//		singleLinkedList.reserver(singleLinkedList.getSingleNode());

		// singleLinkedList.traverse();
		//
		// singleLinkedList.updateNode(newNode);
		//
		// singleLinkedList.delNode(3);
		//
		// singleLinkedList.traverse();
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(13);
		list.add(2);
        Iterator iteratot = list.iterator();
		ListIterator<Integer> i = list.listIterator();
		System.out.println(i.next());
		Collections.sort(list);
		System.out.println(list);

	}
}

// ���嵥�������Node
class SingleLinkedList {

	// ����һ�����ɱ��ͷ�ڵ㣬����ž������Ϣ
	private Node headNode = new Node(0, " ", "");

	// ���ص�ǰ���������
	public Node getSingleNode() {
		return headNode;
	}

	// ����������ӽڵ���Ϣ
	public void add(Node node) {
		// ��Ϊͷ�ڵ㲻�ɶ���������Ҫһ�������ڵ��������������ı���
		Node tmpNode = headNode;
		while (true) {
			if (tmpNode.next == null) {
				break;
			}
			// ���û���ҵ�����Ԫ�أ���tepNode����
			tmpNode = tmpNode.next;
		}
		// �������Ľڵ���Ϣ��ӵ�����������λ��
		tmpNode.next = node;
	}

	// ����˳������������ӽڵ�
	public void addBySquence(Node node) {
		// �˴�ͬ����Ҫ�����ڵ����ͷ�ڵ�����ƶ�
		Node tmpNode = headNode;
		boolean flag = false;
		// ��ʼ�����ڵ㣬���ڵ�Ϊ�գ������ߵ�ǰ�Ľڵ�noֵ�Ѿ�����ʱ�������뵱ǰ���
		while (true) {
			if (tmpNode.next == null) {// ����Ϊ��ʱ��ֱ�Ӳ���
				break;
			}
			if (tmpNode.next.number < node.number) {// ��ǰ�����е��Ѵ��ڵĽ���noֵ����Ҫ����Ľڵ㣨����С�����˳�����У���λ���ҵ������Բ���
				break;
			}
			if (tmpNode.next.number == node.number) {
				flag = true;
				break;
			}
			// �����������������ָ��������ƣ�ֱ���ҵ���node.number���tmpNode
			tmpNode = tmpNode.next;
		}
		if (flag) {
			System.out.println("��ǰ����Ѵ��������У�" + node.number);
		} else {
			// ����ǰ������������,tmpNode�ڵ�ĺ��棬tmpNode.next��ǰ��
			node.next = tmpNode.next;
			tmpNode.next = node;
		}
	}

	// �޸�ĳ���ڵ�
	public void updateNode(Node node) {
		// ������Ҫ�ҵ���Ӧ�Ľڵ��λ�ã�Ȼ������޸�
		Node tmpNode = headNode;
		boolean flag = false;
		while (true) {
			// ��ʾ�����������û���ҵ���Ҫ�����Ϣ�Ľڵ��λ��
			if (tmpNode.next == null) {
				break;
			}
			// �ҵ��ڵ㣬��flag��Ϊture����whileѭ���⽫�ڵ���Ϣ�ı�
			if (tmpNode.next.number == node.number) {
				flag = true;
				break;
			}
			// ������break������ʱ�򣬽�ָ����ƣ�����������ǰ�����
			tmpNode = tmpNode.next;
		}
		if (flag) {
			System.out.println("�Ѿ��ҵ���Ӧ�Ľڵ��λ�ã����޸ĵ�ǰ���" + node.number);
			tmpNode.next.name = node.name;
			tmpNode.next.nickName = node.nickName;
		} else {
			System.out.println("----û���ҵ���Ҫ�޸ĵĽڵ��λ����Ϣ ----");
		}

	}

	// ɾ��ĳ���ڵ�(�ҵ���Ӧ����Ҫɾ���ڵ���Ϣ��ǰһ��λ�ã����ýڵ��next��ָ����)
	// �����number��ʾ�ڵ���Ϣ�е�number
	public void delNode(int number) {
		Node tmpNode = headNode.next;
		boolean flag = false;
		while (true) {
			// ��ʾ��ǰ����Ϊ��
			if (tmpNode == null) {
				break;
			}
			if (tmpNode.next.number == number) {
				flag = true;
				break;
			}
			tmpNode = tmpNode.next;
		}
		if (flag) {
			// ��ʾ�Ѿ��ҵ���Ӧ�Ľڵ�λ�õģ�����ǰһ���ڵ�ΪtmpNode,ɾ���ڵ�ʱֻ��Ҫ���ýڵ��nextָ��tmpNode.next.next����
			tmpNode.next = tmpNode.next.next;
		} else {
			System.out.println("δ�ҵ���Ҫɾ��λ��Ϊ�ڵ���Ϣ");
		}
	}

	// �������еĽڵ㷴ת���ٶ������⣩
	// ˼·��������������ջ���Ƚ�������Զ�������з�ת
	public void reserver(Node node) {
		Node tmpNode = node.next;
		if (tmpNode == null) {
			// ˵��������Ϊ��
			System.out.println("������β�գ��޷���ת");
			return;
		}
		Stack<Node> stackNode = new Stack<Node>();
		while (tmpNode != null) {
			// ȡ����ǰ�������еĽڵ����ջ��
			stackNode.push(tmpNode);
			tmpNode = tmpNode.next;
		}
		// ��whileѭ����������ʾ�Ѿ������������
		// ע��㣬����ʹ��pop��ʱ�򵯳�ջ��ͷԪ�أ���ʱstack.sizeҲ�Ǳ�С�ģ�����ʹ��һ����������ǰ��size�̶�
		int stackSize = stackNode.size();
		for (int i = 0; i < stackSize; i++) {
			System.out.println("��ӡ����ǰ����ת��Ľ���ǣ�" + stackNode.pop());
		}
	}

	// ��������
	public void traverse() {
		if (headNode.next == null) {
			System.out.println("����Ϊ��---");
			return;
		}
		// ��Ϊͷ�ڵ㲻�ɶ���������Ҫһ�������ڵ��������������ı���
		Node tmpNode = headNode.next;
		while (true) {
			// ���ڵ��nextΪ��ʱ�����ʾ�Ѿ���������β
			if (tmpNode == null) {
				break;
			}
			// ��ӡ��ǰ�Ľڵ���Ϣ
			System.out.println(tmpNode.toString());
			// ��ӡ����ǰ�����Ϣ֮�󣬽��ڵ����
			tmpNode = tmpNode.next;
		}
	}
}

// ����Node�ڵ�
class Node {
	public int number;
	public String name;
	public String nickName;
	public Node next;

	public Node(int numberNmber, String name, String nickName) {
		this.number = numberNmber;
		this.nickName = nickName;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + ", name=" + name + ", nickName=" + nickName + "]";
	}

}
