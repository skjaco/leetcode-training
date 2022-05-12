import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * https://leetcode.cn/problems/lexicographical-numbers/
 * <p>
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * <p>
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 13
 * 输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：[1,2]
 */
public class LexicalOrder {
    public List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i < 10; i++) {
            process(i, n);
        }
        return ans;
    }

    public void process(int curr, int n) {
        if (curr > n) {
            return;
        }
        ans.add(curr);
        for (int i = 0; i < 10; i++) {
            int num = curr * 10 + i;
            if (num > n) {
                break;
            }
            process(num, n);
        }
    }
}
