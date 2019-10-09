package test.tree;

//创建一个二叉树并且顺序打印出前序遍历，中序遍历，后续遍历 day10-09
public class BinaryTree {

	public static void main(String[] args) {

		HeroNode heroNode1 = new HeroNode(1, "张一");
		HeroNode heroNode2 = new HeroNode(2, "李二");
		HeroNode heroNode3 = new HeroNode(3, "张三");
		HeroNode heroNode4 = new HeroNode(4, "王四");
		
		heroNode1.setLeft(heroNode2);
		heroNode1.setRight(heroNode3);
		heroNode3.setRight(heroNode4);
		
		HeroNodeTree heroNodeTree = new HeroNodeTree();
		
		heroNodeTree.setRoot(heroNode1);
		
		//前序遍历 1234
		System.out.println("前序遍历");
		heroNodeTree.preTree();
		
		System.out.println("中序遍历");
		//中序遍历2134
		heroNodeTree.midTree();
		
		//后序遍历2431
		System.out.println("后序遍历");
		heroNodeTree.befTree();
	}

}

//创建二叉树
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
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public void midTree() {
		if (root != null) {
			root.midHeroNode();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}

	public void befTree() {
		if (root != null) {
			root.befHeroNode();
		}else {
			System.out.println("二叉树为空，无法遍历");
		}
	}
}

// 创建二叉树节点
class HeroNode {

	private int id;
	private String name;
	private HeroNode left;// 创建左指针
	private HeroNode right;// 创建右指针 默认为空

	// 创建构造器，方便测试时创建二叉树系节点信息
	public HeroNode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	// 使用递归的方法分别创建二叉树前序遍历，中序遍历，后序遍历

	/**
	 * 前序遍历
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
	 * 中序遍历
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
	 * 后序遍历
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
