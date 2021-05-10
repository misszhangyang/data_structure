package study.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: data_structure
 * @description: 二叉树遍历
 * 深度优先遍历：主要分为三种
 * 1 先序遍历  上左右
 * 2 中序遍历  左上右
 * 3 后续遍历  左右上
 * 广度优先遍历：遍历当前节点的所有上左右节点之后再去遍历子节点的上左右
 * 1 上左右
 * @author: Mr.ZhangYang
 * @create: 2021-05-10 14:48
 **/
public class Dync0510BinaryTreeTraversal {

    static Stack<TreeNode> stack = new Stack();


    public static void main(String[] args) {
        /**
         *        1
         *     2    3       => 二叉树结构
         *  4   5  6  7
         */
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        TreeNode node = new TreeNode(1);
        node.left = node2;
        node.right = node3;
        System.out.println("二叉树的深度优先遍历的结果是：");
        depthTraver(node);
        System.out.println();
        System.out.println("二叉树的广度优先遍历的结果是：");
        boradTraver(node);
        System.out.println();
        System.out.println("二叉树深度游侠遍历的中序遍历结果是");
        depthTraverCenter(node);
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            System.out.print(" " + pop.value);
        }
        System.out.println();
    }

    /**
     * 深度优先遍历(这里采用先序遍历的方式) => 使用栈的结构存储表示
     * @param node
     */
    public static void depthTraver(TreeNode node){
        if(null == node) return;
        Stack<TreeNode> stack = new Stack();
        stack.add(node);
        while(!stack.empty()){
            TreeNode pop = stack.pop();
            System.out.print(" " + pop.value);
            //由于栈是先进后出的数据结构，为了完成从左到有的遍历，所以需要先将右节点插入栈中
            if(null != pop.right){   ////深度优先遍历，先遍历左边，后遍历右边,栈先进后出
                stack.push(pop.right);
            }
            if(null != pop.left){
                stack.push(pop.left);
            }
        }
    }

    /**
     * 深度优先遍历(这里采用中序遍历的方式) => 使用栈的结构存储表示
     * @param node
     */
    public static void depthTraverCenter(TreeNode headNode){
        if(null == headNode) return;
        TreeNode node;
        if (null != headNode.right){
            node = headNode.right;
            depthTraverCenter(node);
        }
        stack.push(headNode);
        if (null != headNode.left){
            node = headNode.left;
            depthTraverCenter(node);
        }
    }

    /**
     * 广度优先遍历  => 这里使用队列的方式存储表示
     * @param node
     */
    public static void boradTraver(TreeNode node){
        if(null == node) return;
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(node);
        while(!myQueue.isEmpty()){
            TreeNode poll = myQueue.poll();
            System.out.print(" " + poll.value);
            if(null != poll.left){  //我们在这里采用每一行从左到右遍历
                myQueue.add(poll.left);
            }
            if(null != poll.right){
                myQueue.add(poll.right);
            }
        }
    }


    /**
     * 二叉树 节点
     */
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value){
            this.value = value;
        }

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

}
