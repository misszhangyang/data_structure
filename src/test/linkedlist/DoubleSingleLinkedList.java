package test.linkedlist;

/**
 * 单向环形链表
 * @author yang
 * @day 07-15
 */
public class DoubleSingleLinkedList {
	
	public static void main(String[] args) {
		CircleLinkedList circleLinkedList = new CircleLinkedList();
		circleLinkedList.addCircle(3);
		circleLinkedList.viewCircleLinekedList();
	}
}

//创建环形链表
class CircleLinkedList{
	
	private CicleNode first = new CicleNode(0," ");
	
	public void addCircle(int num) {
		if(num < 2) {
			System.out.println("---添加的节点数小于2---");
			return;
		}
		//辅助CircleNode，用于遍历当前环形链表的节点
		CicleNode tmpNode = first;
		while(true) {
			//已经遍历到环形链表的结尾处，则停止循环
			if(tmpNode.getNext() == first) {
				break;
			}
			for(int i = 1; i < num+1; i ++) {
				CicleNode cNode = new CicleNode(i,"name"+i);
				tmpNode.setNext(cNode);
				cNode.setNext(first);
				tmpNode = tmpNode.getNext();
			}
		}
	}
	
	//遍历当前的环形链表信息
	public void viewCircleLinekedList() {
		CicleNode  tmpNode = first;
		while(true) {
			if(tmpNode == null) {
				System.out.println("当前结点信息为空");
				return;
			}
			System.out.println("当前环形链表的节点信息是：" + tmpNode.getNum());
			tmpNode = tmpNode.getNext();
			if(tmpNode == first) {
				System.out.println("遍历环形链表结束");
				break;
			}

		}
	}
}

//创建节点
class CicleNode{
	
	private int num;
	private String name;
	private CicleNode next;
	
	public CicleNode(int num,String name) {
		this.num = num;
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CicleNode getNext() {
		return next;
	}
	public void setNext(CicleNode next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return "Node [num=" + num + ", name=" + name + ", next=" + next + "]";
	}
}
