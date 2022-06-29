import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * https://leetcode.cn/problems/wiggle-sort-ii/
 * <p>
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]… 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 1
 * 2
 * 3
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 */
public class WiggleSort2 {
  public void wiggleSort(int[] nums) {
    // 使用一个临时数组暂存
    int[] tmp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      tmp[i] = nums[i];
    }
    // 对数组进行排序
    Arrays.sort(tmp);
    // left 从较小区域的最右侧开始
    int left = (nums.length - 1) >> 1;
    // right 从较大区域的最右侧开始
    int right = nums.length - 1;
    // 是否选择较小区域
    boolean getSmaller = true;
    for (int i = 0; i < nums.length; i++) {
      if (getSmaller) {
        // 选择较小区域，left 左移一位，并 getSmaller 变为false 下次取较大区域
        nums[i] = tmp[left--];
        getSmaller = false;
      } else {
        // 选择较大区域，right 左移一位，并 getSmaller 变为true 下次取较小区域
        nums[i] = tmp[right--];
        getSmaller = true;
      }
    }
  }
}
