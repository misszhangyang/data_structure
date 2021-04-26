/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 */
public class Dync0617 {
    public static void main(String[] args) {
        int[] A = {12,31,3,43,121};
        int left = A[0], res = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, left + A[j] - j);
            left = Math.max(left, A[j] + j);
        }
        System.out.println(res);
    }
}
/**
 * 可以先从暴力法中找思路
 * 暴力法：算出每两对的 得分取最大值
*         for (j : 1 -> A.length) {
*             for (i : 0 -> j) {
*                 maxvalue = Math.max(maxvalue, A[j] - j   +   A[i] + i);
*            }
*         }
 * 当然是超时的 -------> 优化 贪心算法
 * 从暴力法可以看出在每次计算过程中 在每个 j 都固定 A[j] -j 计算它前面的 A[i] + i 的最大值 (i : 1 -> j)
 * 贪心算法：将问题分解为 A[i] + i 和 A[j] - j 的最大值  i < j
 * 那我们在一次遍历 j 的时候只需要不断保存并且更新 A[i] + i 的值即可求出最大值
 */
