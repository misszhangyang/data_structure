import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dync0618 {
    public static void main(String[] args) {
        Node node = new Node("5");
        Node node1 = new Node("2");
        Node node2 = new Node("3");
        SinggleNode singgleNode = new SinggleNode();
        singgleNode.node = node;
        SinggleNode singgleNode1 = new SinggleNode();
        singgleNode1.node = node1;
        SinggleNode singgleNode2 = new SinggleNode();
        singgleNode2.node = node2;
        singgleNode.nextNode = singgleNode1;
        singgleNode1.nextNode = singgleNode2;
        SinggleNode listNode = new SinggleNode(singgleNode);
        listNode.nextNode = singgleNode;
        listNode.setValue(node);
        //listNode: 1 => 1 => 2 => 3 单向链表 4个节点
        System.out.println(listNode);
        SinggleNode listNode1 = new SinggleNode(singgleNode);
        listNode1.nextNode = singgleNode;
        listNode1.setValue(node2);
        //listNode1 2 => 1 => 2 => 3 单向链表 4个节点
        //遍历链表 listNode
        String item = "";
        int sum1 = 0,sum2 = 0;
        List<Integer> linkedList = new LinkedList<Integer>();
        List<Integer> linkedList1 = new LinkedList<Integer>();
        while(null != listNode){
            item = listNode.node.value;
            linkedList.add(Integer.valueOf(item));
            double cout02 = Math.pow(10,linkedList.size() - 1);
            int chengshu = new Double(cout02).intValue();
            sum1 = sum1 + Integer.valueOf(item) * chengshu;
            listNode = listNode.nextNode;
        }
        while (null != listNode1){
            item = listNode1.node.value;
            linkedList1.add(Integer.valueOf(item));
            double cout02 = Math.pow(10,linkedList1.size() - 1);
            int chengshu = new Double(cout02).intValue();
            sum2 = sum2 + Integer.valueOf(item) * chengshu;
            listNode1 = listNode1.nextNode;
        }
        int totalSum = sum1 + sum2; //3211 + 3213 = 6424
        String [] arr = String.valueOf(totalSum).split("");
        SinggleNode outSing = new SinggleNode();//全新
        SinggleNode printSing = new SinggleNode();
        Stack stack = new Stack();
        for(String str : arr){ //6 4 2 4 => 4 2 4 6
            stack.push(str);
//            Node newNode = new Node(str); //6
//            SinggleNode singgle = new SinggleNode(newNode);
//            if(null == outSing.nextNode){
//                outSing.nextNode = singgle;
//            }else {
//                outSing.nextNode.nextNode = singgle;
//                outSing = outSing.nextNode;
//            }
        }
        while (!stack.empty()){
            System.out.print(stack.pop());
            if(!stack.isEmpty()){
                System.out.print("=>");
            }
        }
        System.out.println();
    }

    static  class Node{
        private String value;
        public Node(String value){
            this.value = value;
        }
    }

    static class SinggleNode{
        //单项链表
        private SinggleNode nextNode;
        //对应的value
        private Node node;

        public SinggleNode() {
        }

        public SinggleNode(Node nextNode) {
            this.node = nextNode;
        }

        public SinggleNode(SinggleNode nextNode) {
            this.nextNode = nextNode;
        }

        public SinggleNode getNextNode() {
            return nextNode;
        }

        public void setNextNode(SinggleNode nextNode) {
            this.nextNode = nextNode;
        }

        public Node getValue() {
            return node;
        }

        public void setValue(Node value) {
            this.node = value;
        }

        @Override
        public String toString() {
            return "SinggleNode{" +
                    "nextNode=" + nextNode +
                    ", node=" + node +
                    '}';
        }
    }
}
