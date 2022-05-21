/**
 * 961. 在长度 2N 的数组中找出重复 N 次的元素
 * https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
 * <p>
 * 给你一个整数数组 nums ，该数组具有以下属性：
 * <p>
 * nums.length == 2 * n.
 * nums 包含 n + 1 个 不同的 元素
 * nums 中恰有一个元素重复 n 次
 * 找出并返回重复了 n 次的那个元素。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [5,1,5,2,5,3,5,4]
 * 输出：5
 */
public class RepeatedNTimes {
    public int repeatedNTimes(int[] nums) {
        int[] arr = new int[10001];
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] != 0) {
                return nums[i];
            } else {
                arr[nums[i]] = 1;
            }
        }
        return 0;
    }
}
