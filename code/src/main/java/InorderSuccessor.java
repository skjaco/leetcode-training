/**
 * 面试题 04.06. 后继者
 * https://leetcode.cn/problems/successor-lcci/
 * <p>
 * 设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 * <p>
 * 如果指定节点没有对应的“下一个”节点，则返回null。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root =
 * [2,1,3], p = 1
 * <p>
 * 2
 * / \
 * 1   3
 * <p>
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: root =
 * [5,3,6,2,4,null,null,1], p = 6
 * <p>
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * <p>
 * 输出: null
 */
public class InorderSuccessor {
  TreeNode ans = null;
  boolean findP = false;

  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    process(root, p);
    return ans;
  }

  public void process(TreeNode root, TreeNode p) {
    if (root == null || ans != null) {
      return;
    }
    process(root.left, p);
    if (findP && ans == null) {
      ans = root;
      return;
    }
    if (root == p) {
      findP = true;
    }
    process(root.right, p);
  }

  private static class TreeNode {
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
