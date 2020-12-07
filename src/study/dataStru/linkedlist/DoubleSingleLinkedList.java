package study.dataStru.linkedlist;

/**
 * ����������
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

//������������
class CircleLinkedList{
	
	private CicleNode first = new CicleNode(0," ");
	
	public void addCircle(int num) {
		if(num < 2) {
			System.out.println("---��ӵĽڵ���С��2---");
			return;
		}
		//����CircleNode�����ڱ�����ǰ��������Ľڵ�
		CicleNode tmpNode = first;
		while(true) {
			//�Ѿ���������������Ľ�β������ֹͣѭ��
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
	
	//������ǰ�Ļ���������Ϣ
	public void viewCircleLinekedList() {
		CicleNode  tmpNode = first;
		while(true) {
			if(tmpNode == null) {
				System.out.println("��ǰ�����ϢΪ��");
				return;
			}
			System.out.println("��ǰ��������Ľڵ���Ϣ�ǣ�" + tmpNode.getNum());
			tmpNode = tmpNode.getNext();
			if(tmpNode == first) {
				System.out.println("���������������");
				break;
			}

		}
	}
}

//�����ڵ�
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
