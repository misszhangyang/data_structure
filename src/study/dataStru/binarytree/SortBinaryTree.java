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
 *
 * 二叉排序树：中序遍历的时候从小到达的方式排列，即左边节点的
 * value小于节点value，右边节点的value大于节点value
 * 平衡二叉树：在满足二叉排序树的基础条件上，又要满足左右节点的高度差不能大于1
 * 多叉树：  每个节点的存储的value不止一个，eg；右2-3树，b树，b+树等
 * 2-3树： 每个节点最多存储2-3个value,且是从小到大排列
 * b树： 每个节点可以存储多个value，且从小到大排列
 * B+树：只有最低层的叶子节点会存储value值，子节点上只存储一般value作为索引，所以它相比b树最大的优势是可以更好的支持范围查询
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
        System.out.println("--------------------------");
        System.out.println(beTree.calRightHeight());
        System.out.println("开始计算这棵树的高度差");
        System.out.println(beTree.isOverHeight());

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

    /**
     * 计算这棵树的右节点的高度
     * @return
     */
    public int calRightHeight(){
        return this.root.calRightHeight(this.root);
    }

    /**
     * 统计这棵树的左节点的高度
     * @return
     */
    public int calLeftHeight(){
        return this.root.caLeftHeight(this.root);
    }

    /**
     * 判断左右节点树的高度差大于1的各种情况
     * 0 => 高度差没有大于1
     * -1 => 左子树的高度差比右子树的高
     * 1 => 右子树的高度比左子树的高
     * @return
     */
    public int isOverHeight(){
        if(calLeftHeight() - calRightHeight() > 1){
            return -1;
        }
        if(calRightHeight() - calLeftHeight() > 1){
            return -1;
        }
        return 0;
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


    /**
     * 计算左子树的的高度
     * @param node
     * @return
     */
    public int caLeftHeight(Node node){
        if(node.left != null){
            return node.left.caLeftHeight(node.left) + 1;
        }
        return 1;
    }

    /**
     * 计算右子树的的高度
     * @param node
     * @return
     */
    public int calRightHeight(Node node){
        if(node.right != null){
            return node.right.calRightHeight(node.right) + 1;
        }
        return 1;
    }
}