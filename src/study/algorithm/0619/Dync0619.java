import java.util.Stack;

/**
 * 0619算法题01
 * 判断一个字符串是否为回文字符串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 输入: "race a car"
 * 输出: false
 *
 * 0619算法题02
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
  */
public class Dync0619 {



    public static void main(String[] args) {
        String str = "qwe8rertrer8ew q";
        String newStr = str.replace(" ","");
        System.out.println(isHuiWen(newStr));
    }

    private static boolean isHuiWen(String str){
        String[] strArr = str.split("");
        Stack<String> stack = new Stack<>();
        for(String item : strArr){
            stack.push(item);
        }
        boolean huiwen = true;
        for(String item : strArr){
            String itemStr = stack.pop();
            if(!item.equals(itemStr)){
                huiwen = false;
            }
        }
        return huiwen;
    }
}
