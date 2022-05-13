/**
 * 面试题 01.05. 一次编辑
 * https://leetcode.cn/problems/one-away-lcci/
 * <p>
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 */
public class OneEditAway {
  public boolean oneEditAway(String first, String second) {
    if (Math.abs(first.length() - second.length()) > 1) {
      return false;
    }
    int firstPtr = 0;
    int secondPtr = 0;
    int op = 0;
    while (firstPtr < first.length() && secondPtr < second.length()) {
      if (first.charAt(firstPtr) == second.charAt(secondPtr)) {
        firstPtr++;
        secondPtr++;
      } else {
        if (op == 1) {
          return false;
        }
        if (first.length() > second.length()) {
          firstPtr++;
        } else if (first.length() < second.length()) {
          secondPtr++;
        } else {
          firstPtr++;
          secondPtr++;
        }
        op++;
      }
    }
    return true;
  }
}
