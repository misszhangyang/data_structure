import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * <p>
 * 0619算法题02
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class Dync0619 {

    public static List<int[]> getNum(int[] arr, int sum) {
        List<int[]> listArr = new ArrayList<>();
        int itemSUm = 0;
        for (int i = 0; i < arr.length; i++) {
            itemSUm = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                int secSUm = arr[j];
                for (int k = j + 1; k < arr.length; k++) {
                    if (secSUm + arr[k] + itemSUm == sum) {
                        int[] arr3 = new int[3];
                        arr3[0] = i;
                        arr3[1] = j;
                        arr3[2] = k;
                        listArr.add(arr3);
                    }
                }
            }
        }
        return listArr;
    }

    public List<int[]> getListSum(int[] arr,int total){

        return null;
    }

    public boolean isSUm(int[] arr, int index, int sum) {
       return  arr[index] == sum;
    }


    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 2, -4, 2};
        List<int[]> list = getNum(arr, 4);
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
//        String str = "qwe8rertrer8ew q";
//        String newStr = str.replace(" ","");
//        System.out.println(isHuiWen(newStr));
    }

    private static boolean isHuiWen(String str) {
        String[] strArr = str.split("");
        Stack<String> stack = new Stack<>();
        for (String item : strArr) {
            stack.push(item);
        }
        boolean huiwen = true;
        for (String item : strArr) {
            String itemStr = stack.pop();
            if (!item.equals(itemStr)) {
                huiwen = false;
            }
        }
        return huiwen;
    }
}
