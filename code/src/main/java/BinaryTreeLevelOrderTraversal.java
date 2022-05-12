import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * <p>
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);
        int tmp = 0;
        List<Integer> tmpList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            tmpList.add(poll.val);
            if (poll.left != null) {
                queue.add(poll.left);
                tmp++;
            }
            if (poll.right != null) {
                queue.add(poll.right);
                tmp++;
            }
            if (tmp == queue.size()) {
                tmp = 0;
                result.add(copy(tmpList));
                tmpList.clear();
            }
        }
        return result;
    }

    public List<Integer> copy(List<Integer> list) {
        List<Integer> newArray = new ArrayList<>();
        for (Integer ele : list) {
            newArray.add(ele);
        }
        return newArray;
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
