import java.util.Arrays;
import java.util.Comparator;

/**
 * 436. 寻找右区间
 * https://leetcode.cn/problems/find-right-interval/
 * <p>
 * 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。
 * <p>
 * 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。
 * <p>
 * 返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,2]]
 * 输出：[-1]
 * 解释：集合中只有一个区间，所以输出-1。
 * 示例 2：
 * <p>
 * 输入：intervals = [[3,4],[2,3],[1,2]]
 * 输出：[-1,0,1]
 * 解释：对于 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间[3,4]具有最小的“右”起点;
 * 对于 [1,2] ，区间[2,3]具有最小的“右”起点。
 * 示例 3：
 * <p>
 * 输入：intervals = [[1,4],[2,3],[3,4]]
 * 输出：[-1,2,-1]
 * 解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
 * 对于 [2,3] ，区间 [3,4] 有最小的“右”起点。
 */
public class FindRightInterval {
  public int[] findRightInterval(int[][] intervals) {
    int[] ans = new int[intervals.length];
    if (intervals.length == 1) {
      ans[0] = -1;
      return ans;
    }
    Info[] list = new Info[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      Info info = new Info(i, intervals[i][0]);
      list[i] = info;
    }
    Arrays.sort(list, Comparator.comparingInt(o -> o.value));
    for (int i = 0; i < intervals.length; i++) {
      ans[i] = getRightArea(list, intervals[i][1]);
    }
    return ans;
  }

  public int getRightArea(Info[] list, int num) {
    if (num > list[list.length - 1].value) {
      return -1;
    }
    int left = 0;
    int right = list.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (list[mid].value > num) {
        right = mid;
      } else if (list[mid].value < num) {
        left = mid + 1;
      } else {
        return list[mid].index;
      }
    }
    return list[left].index;
  }

  private class Info {
    int value;
    int index;

    public Info(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}
