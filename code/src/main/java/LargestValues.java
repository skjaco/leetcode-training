import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 515. 在每个树行中找最大值
 * https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * <p>
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * 示例1：
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 1
 * 2
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 */
public class LargestValues {
  public List<Integer> largestValues(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    if (root == null) {
      return ans;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int count = 1;
    int max = root.val;
    while (!queue.isEmpty()) {
      if (count == queue.size()) {
        // 遍历完一层之后将这一层最大值放入结果列表，并初始化最大值和放入次数
        ans.add(max);
        max = Integer.MIN_VALUE;
        count = 0;
      }
      TreeNode poll = queue.poll();
      // 放入左右节点时，计算最大值
      if (poll.left != null) {
        max = Math.max(max, poll.left.val);
        queue.offer(poll.left);
        count++;
      }
      if (poll.right != null) {
        max = Math.max(max, poll.right.val);
        queue.offer(poll.right);
        count++;
      }
    }
    return ans;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
