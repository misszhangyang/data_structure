package study.dataStru.binarytree;

/**
 * @Author: yangzhang
 * @Description: 二叉排序树
 * @Date: 2020/10/31 11:27 上午
 * @Version: 1.0
 *
 * 新增平衡二叉树的方法
 * 流程：在结点的左节点和右节点的高度差大于1的时候，开始进行旋转操作
 * 1 查询左节点的高度
 * 2 查询右节点的高度
 * 3 高度差大于1的时候开始进行旋转操作
 * 4 在旋转的时候需要依据实际的情况分清楚是进行左旋转还是进行右旋转
 * 5 旋转的时候需要进行判空的操作，在旋转完成之后需要进行return操作，避免出现浪费资源的程序判断
 */
public class SortBinaryTree {

    public static void main(String[] args) {

        int[] arr = {17,6,3,2,45,23,84};
        BeTree beTree = new BeTree();
        for(int i = 0; i < arr.length; i++){
            Node node = new Node(arr[i]);
            beTree.initBtree(node);
        }
        beTree.infoBetween();

    }

}


class BeTree{

    private Node root;

    public void initBtree(Node node){
        if(this.root == null){
            this.root = node;
        }else
            this.root.add(node);
    }

    /**
     * 中序遍历二叉树
     * @param
     */
    public void infoBetween(){
        this.root.inforBet();
    }

}


class Node {

    int value;

    Node left;

    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value + ",";
    }

    public void inforBet() {
        if (this.left != null) {
            this.left.inforBet();
        }
        System.out.print(this);
        if (this.right != null) {
            this.right.inforBet();
        }
    }

    /**
     * 添加一个节点
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }


    public void
}