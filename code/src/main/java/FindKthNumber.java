/**
 * 668. 乘法表中第k小的数
 * https://leetcode.cn/problems/kth-smallest-number-in-multiplication-table/
 * <p>
 * 几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
 * <p>
 * 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。
 * <p>
 * 例 1：
 * <p>
 * 输入: m = 3, n = 3, k = 5
 * 输出: 3
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * 第5小的数字是 3 (1, 2, 2, 3, 3).
 * 例 2：
 * <p>
 * 输入: m = 2, n = 3, k = 6
 * 输出: 6
 * 解释:
 * 乘法表:
 * 1	2	3
 * 2	4	6
 * <p>
 * 第6小的数字是 6 (1, 2, 2, 3, 4, 6).
 */
public class FindKthNumber {
  public int findKthNumber(int m, int n, int k) {
    int left = 1;
    int right = m * n;
    while (left < right) {
      int mid = (left + right) / 2;
      int lessThanMid = 0;
      for (int i = 1; i <= m; i++) {
        lessThanMid += i * n <= mid ? n : mid / i;
      }
      if (lessThanMid < k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
