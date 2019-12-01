package test.hauffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HaffManTree {

	public static void main(String[] args) {

		int[] arr = {3,23,1,5,6,8,9,90};
		List<HaFuManNode> list = new HaffManTree().buildHaFuManTree(arr);
		for(HaFuManNode node : list) {
			new HaffManTree().preNode(node);
		}
	}

	/**
	 * @param list
	 */
	public void preNode(HaFuManNode list) {
		
		System.out.println(list.getValue());
		
		if(list.getLeftNode() != null) {
			preNode(list.getLeftNode());
		}
		if(list.getRightNode() != null) {
			preNode(list.getRightNode());
		}
		if(list.getLeftNode() == null && list.getRightNode() == null) {
			return;
		}
	}
	
	public List<HaFuManNode> buildHaFuManTree(int[] arr) {
		List<HaFuManNode> listTree = new ArrayList<HaFuManNode>();
		for (int i : arr) {
            listTree.add(new HaFuManNode(i));
		}
		HaFuManNode hafuManTree = new HaFuManNode(0);
		Collections.sort(listTree);
		int index = 1;
		while(listTree.size() > 1) {
			HaFuManNode min = listTree.get(0);
			HaFuManNode secMin = listTree.get(1);
			hafuManTree.setValue(min.getValue() + secMin.getValue());
			hafuManTree.setLeftNode(listTree.get(0));
			hafuManTree.setRightNode(listTree.get(1));
			listTree.remove(min);
			listTree.remove(secMin);
			listTree.add(hafuManTree);
			Collections.sort(listTree);
			System.out.println("µÚ"+index+"´ÎÅÅÐòºó£º"+listTree);
			index++;
		}
		return listTree;
	}

	class HaFuManNode implements Comparable<HaFuManNode> {

		private HaFuManNode leftNode;
		private HaFuManNode rightNode;
		private int value;

		public HaFuManNode(int value) {
			this.value = value;
		}

		public HaFuManNode getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(HaFuManNode leftNode) {
			this.leftNode = leftNode;
		}

		public HaFuManNode getRightNode() {
			return rightNode;
		}

		public void setRightNode(HaFuManNode rightNode) {
			this.rightNode = rightNode;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "HaFuManNode [value=" + value + "]";
		}

		@Override
		public int compareTo(HaFuManNode o) {
			return this.value - o.value;
		}

	}

}
