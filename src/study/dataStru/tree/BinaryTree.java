package study.dataStru.tree;

//����һ������������˳���ӡ��ǰ������������������������ day10-09
public class BinaryTree {

	public static void main(String[] args) {

		HeroNode heroNode1 = new HeroNode(1, "��һ");
		HeroNode heroNode2 = new HeroNode(2, "���");
		HeroNode heroNode3 = new HeroNode(3, "����");
		HeroNode heroNode4 = new HeroNode(4, "����");
		
		heroNode1.setLeft(heroNode2);
		heroNode1.setRight(heroNode3);
		heroNode3.setRight(heroNode4);
		
		HeroNodeTree heroNodeTree = new HeroNodeTree();
		
		heroNodeTree.setRoot(heroNode1);
		
		//ǰ����� 1234
		System.out.println("ǰ�����");
		heroNodeTree.preTree();
		
		System.out.println("�������");
		//�������2134
		heroNodeTree.midTree();
		
		//�������2431
		System.out.println("�������");
		heroNodeTree.befTree();
	}

}

//����������
class HeroNodeTree {

	private HeroNode root;

	public HeroNode getRoot() {
		return root;
	}

	public void setRoot(HeroNode root) {
		this.root = root;
	}

	public void preTree() {
		if (root != null) {
			root.preHeroNode();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	public void midTree() {
		if (root != null) {
			root.midHeroNode();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}

	public void befTree() {
		if (root != null) {
			root.befHeroNode();
		}else {
			System.out.println("������Ϊ�գ��޷�����");
		}
	}
}

// �����������ڵ�
class HeroNode {

	private int id;
	private String name;
	private HeroNode left;// ������ָ��
	private HeroNode right;// ������ָ�� Ĭ��Ϊ��

	// �������������������ʱ����������ϵ�ڵ���Ϣ
	public HeroNode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// ʹ�õݹ�ķ����ֱ𴴽�������ǰ�����������������������

	/**
	 * ǰ�����
	 */
	public void preHeroNode() {

		System.out.println(this);

		if (this.left != null) {
			this.left.preHeroNode();
		}
		if (this.right != null) {
			this.right.preHeroNode();
		}
	}

	/**
	 * �������
	 */
	public void midHeroNode() {
		if (this.left != null) {
			this.left.midHeroNode();
		}

		System.out.println(this);

		if (this.right != null) {
			this.right.midHeroNode();
		}
	}

	/**
	 * �������
	 */
	public void befHeroNode() {
		if (this.left != null) {
			this.left.befHeroNode();
		}

		if (this.right != null) {
			this.right.befHeroNode();
		}

		System.out.println(this);
	}

	@Override
	public String toString() {
		return "HeroNode [id=" + id + ", name=" + name + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroNode getLeft() {
		return left;
	}

	public void setLeft(HeroNode left) {
		this.left = left;
	}

	public HeroNode getRight() {
		return right;
	}

	public void setRight(HeroNode right) {
		this.right = right;
	}

}
