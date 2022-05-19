import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * <p>
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最少移动数。
 * <p>
 * 在一步操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两步操作（每步操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 */
public class MinMoves2 {
  public int minMoves2(int[] nums) {
    if (nums.length == 2) {
      return Math.abs(nums[0] - nums[1]);
    }
    Arrays.sort(nums);
    int mid = nums.length / 2;
    long ans1 = 0L;
    for (int num : nums) {
      ans1 += Math.abs(num - nums[mid]);
    }
    return (int) ans1;
  }
}
