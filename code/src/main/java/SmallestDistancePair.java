import java.util.Arrays;

/**
 * 719. 找出第 K 小的数对距离
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * <p>
 * 数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1], k = 1
 * 输出：0
 * 解释：数对和对应的距离如下：
 * (1,3) -> 2
 * (1,1) -> 0
 * (3,1) -> 2
 * 距离第 1 小的数对是 (1,1) ，距离为 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1], k = 2
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1,6,1], k = 3
 * 输出：5
 */
public class SmallestDistancePair {
  public int smallestDistancePair(int[] nums, int k) {
    Arrays.sort(nums);
    int left = 0;
    int right = nums[nums.length - 1] - nums[0];
    while (left < right) {
      int mid = (left + right) / 2;
      int countPairs = countPairs(nums, mid);
      if (countPairs < k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public int countPairs(int[] nums, int mid) {
    int l = 0;
    int r = 0;
    int count = 0;
    while (r < nums.length) {
      while (l < r && nums[r] - nums[l] > mid) {
        l++;
      }
      count += r - l;
      r++;
    }
    return count;
  }
}
