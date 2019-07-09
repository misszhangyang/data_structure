package test.linkedlist;

/**
 * 单链表的实现
 * day07-09
 * @author yang
 *
 */
public class LinkedList {
	public static void main(String[] args) {
		
          Node node1 = new Node(1,"李浩","lihao");
          Node node2 = new Node(2,"销摩","xiaomo");
          Node node3 = new Node(3,"张咪","zhangmi");
          Node node4 = new Node(4,"萧峰","xiaofen");
          
          SingleLinkedList  singleLinkedList = new SingleLinkedList();
//          singleLinkedList.add(node1);
//          singleLinkedList.add(node2);
//          singleLinkedList.add(node4);
//          singleLinkedList.add(node3);
          
          singleLinkedList.addBySquence(node1);
          singleLinkedList.addBySquence(node2);
          singleLinkedList.addBySquence(node4);
          singleLinkedList.addBySquence(node3);
          singleLinkedList.addBySquence(node3);
          
          singleLinkedList.traverse();
         
          
          
	}
}

// 定义单链表管理Node
class SingleLinkedList {
	
	//定义一个不可变的头节点，不存放具体的信息
	private Node headNode = new Node(0, " ", "");

	// 向链表中添加节点信息
	public void add(Node node) {
		//因为头节点不可动，所以需要一个辅助节点变量来进行链表的遍历
		Node tmpNode = headNode;
		while (true) {
			if (tmpNode.next == null) {
				break;
			}
			// 如果没有找到最后的元素，则将tepNode后移
			tmpNode = tmpNode.next;
		}
		//将新增的节点信息添加到单链表的最后位置
		tmpNode.next = node;
	}
	
	//按照顺序向链表中添加节点
	public void addBySquence(Node node) {
		//此处同样需要辅助节点代替头节点进行移动
		Node tmpNode = headNode;
		boolean flag = false;
		//开始遍历节点，当节点为空，，或者当前的节点no值已经存在时，不插入当前结点
		while(true) {
			if(tmpNode.next == null) {//链表为空时，直接插入
				break;
			}
			if(tmpNode.next.number < node.number) {//当前链表中的已存在的结点的no值大于要插入的节点（按从小到大的顺序排列），位置找到，可以插入
				break;
			}
			if(tmpNode.next.number == node.number) {
				flag = true;
				break;
			}
			//均不满足插入条件，指针继续后移，直到找到比node.number大的tmpNode
			tmpNode = tmpNode.next;
		}
		if(flag) {
			System.out.println("当前结点已存在链表中：" + node.number );
		}else {
			//将当前结点插入链表中,tmpNode节点的后面，tmpNode.next的前面
			node.next = tmpNode.next;
			tmpNode.next = node;
		}
	}
	
	//遍历链表
	public void traverse() {
		if(headNode.next == null) {
			System.out.println("链表为空---");
			return;
		}
		//因为头节点不可动，所以需要一个辅助节点变量来进行链表的遍历
		Node tmpNode = headNode.next;
		while(true) {
			//当节点的next为空时，则表示已经遍历到结尾
			if(tmpNode == null) {
				break;
			}
			//打印当前的节点信息
			System.out.println(tmpNode.toString());
			//打印出当前结点信息之后，将节点后移
			tmpNode = tmpNode.next;
		}
	}
}

// 定义Node节点
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
