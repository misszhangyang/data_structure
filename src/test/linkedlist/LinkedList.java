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
          Node newNode = new Node(4,"天龙八部","tianlongbabu");
          
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
          
          singleLinkedList.updateNode(newNode);
          
          singleLinkedList.delNode(3);
          
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
	
	//修改某个节点
	public void updateNode(Node node) {
		//首先需要找到对应的节点的位置，然后进行修改
		Node tmpNode = headNode;
		boolean flag = false;
		while(true) {
			//表示遍历到最后还是没有找到需要变更信息的节点的位置
			if(tmpNode.next == null) {
				break;
			}
			//找到节点，将flag变为ture，在while循环外将节点信息改变
			if(tmpNode.next.number == node.number) {
				flag = true;
				break;
			}
			//不符合break条件的时候，将指针后移，继续遍历当前链表的
			tmpNode = tmpNode.next;
		}
		if(flag) {
			System.out.println("已经找到对应的节点的位置，并修改当前结点" + node.number);
			tmpNode.next.name = node.name;
			tmpNode.next.nickName = node.nickName;
		}else {
			System.out.println("----没有找到需要修改的节点的位置信息 ----");
		}
		
	}
	
	//删除某个节点(找到对应的需要删除节点信息的前一个位置，将该节点的next的指向变更)
	//这里的number表示节点信息中的number
	public void delNode(int number) {
		Node tmpNode = headNode.next;
		boolean flag = false;
		while(true) {
			//表示当前链表为空
			if(tmpNode == null) {
				break;
			}
			if(tmpNode.next.number == number) {
				flag = true;
				break;
			}
			tmpNode = tmpNode.next;
		}
		if(flag) {
			//表示已经找到对应的节点位置的，它的前一个节点为tmpNode,删除节点时只需要将该节点的next指向tmpNode.next.next即可
			tmpNode.next = tmpNode.next.next;
		}else {
			System.out.println("未找到需要删除位置为节点信息");
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
