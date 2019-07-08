package test.linkedlist;

/**
 * �������ʵ��
 * 
 * @author yang
 *
 */
public class LinkedList {
	public static void main(String[] args) {

	}
}

// ���嵥�������Node
class SingleLinkedList {
	private Node node1 = new Node(0, " ", "");

	public SingleLinkedList(Node node) {
		this.node1 = node;
	}

	// ����������ӽڵ���Ϣ
	public void add(Node node) {
		Node tmpNode = node;
		while (true) {
			if (node.nextNode == null) {
				System.out.println("�ڵ�����");
				return;
			}
			// ��ӽڵ���Ϣ��node��
			tmpNode = tmpNode.nextNode;
		}
	}
}

// ����Node�ڵ�
class Node {
	public int number;
	public String name;
	public String nickName;
	public Node nextNode;

	public Node(int numberNmber, String name, String nickName) {
		this.number = numberNmber;
		this.nickName = nickName;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + ", name=" + name + ", nickName=" + nickName + ", nextNode=" + nextNode + "]";
	}

}
