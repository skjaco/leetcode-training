/**
 * 965. 单值二叉树
 * https://leetcode.cn/problems/univalued-binary-tree/
 * <p>
 * 如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。
 * <p>
 * 只有给定的树是单值二叉树时，才返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：[1,1,1,1,1,null,1]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：[2,2,2,5,2]
 * 输出：false
 */
public class IsUnivalTree {
  int pre;
  boolean ans = true;

  public boolean isUnivalTree(TreeNode root) {
    pre = root.val;
    process(root);
    return ans;
  }

  public void process(TreeNode root) {
    if (root == null) {
      return;
    }
    if (root.val != pre) {
      ans = false;
    }
    process(root.left);
    process(root.right);
  }

  public class TreeNode {
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
