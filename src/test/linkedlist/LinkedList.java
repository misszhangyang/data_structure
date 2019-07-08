package test.linkedlist;

/**
 * 单链表的实现
 * 
 * @author yang
 *
 */
public class LinkedList {
	public static void main(String[] args) {

	}
}

// 定义单链表管理Node
class SingleLinkedList {
	private Node node1 = new Node(0, " ", "");

	public SingleLinkedList(Node node) {
		this.node1 = node;
	}

	// 向链表中添加节点信息
	public void add(Node node) {
		Node tmpNode = node;
		while (true) {
			if (node.nextNode == null) {
				System.out.println("节点已满");
				return;
			}
			// 添加节点信息到node中
			tmpNode = tmpNode.nextNode;
		}
	}
}

// 定义Node节点
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
