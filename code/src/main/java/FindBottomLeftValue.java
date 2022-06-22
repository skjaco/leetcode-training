/**
 * 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * <p>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 1
 * 2
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * 1
 * 2
 */
public class FindBottomLeftValue {
  public int findBottomLeftValue(TreeNode root) {
    int head = 0;
    int tail = 0;
    TreeNode[] queue = new TreeNode[10000];
    queue[tail++] = root;
    int count = 1;
    TreeNode ans = null;
    while (tail - head > 0) {
      if (count == tail - head) {
        ans = queue[head];
        count = 0;
      }
      TreeNode poll = queue[head++];
      if (poll.left != null) {
        queue[tail++] = poll.left;
        count++;
      }
      if (poll.right != null) {
        queue[tail++] = poll.right;
        count++;
      }
    }
    return ans.val;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int vat) {
      this.val = vat;
    }

    public void left(TreeNode left) {
      this.left = left;
    }

    public void right(TreeNode right) {
      this.right = right;
    }

  }
}
