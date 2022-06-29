import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/
 * <p>
 * 给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 1
 * 2
 * 3
 * 4
 * 5
 * 示例 2：
 * <p>
 * 输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * 输出：[]
 * 1
 * 2
 * 示例 3：
 * <p>
 * 输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
 * 输出：[6,9,12]
 */
public class FindSubstring {
  public List<Integer> findSubstring(String s, String[] words) {
    Map<String, Integer> wordsMap = new HashMap<>();
    // 获取一个单词的长度
    int wordLength = words[0].length();
    // 计算 words 数组所有字符串长度作为窗口长度
    int length = wordLength * words.length;
    for (int i = 0; i < words.length; i++) {
      // 统计 words 数组中每个字符串出现的次数
      wordsMap.put(words[i], wordsMap.getOrDefault(words[i], 0) + 1);
    }
    List<Integer> ans = new ArrayList<>();
    outerLoop:
    for (int i = 0; i <= s.length() - length; i++) {
      Map<String, Integer> windowMap = new HashMap<>();
      int j = i;
      while (j <= i + length - wordLength) {
        // 获取窗口内单词
        String word = s.substring(j, j + wordLength);
        if (!wordsMap.containsKey(word)) {
          // 如果单词不在 words 数组中，退出当前窗口
          continue outerLoop;
        }
        if (windowMap.getOrDefault(word, 0) + 1 > wordsMap.get(word)) {
          // 如果统计单词个数比 words 中该单词个数多，退出当前窗口
          continue outerLoop;
        }
        // 统计窗口内单词出现次数
        windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
        // 从下一个单词开始统计
        j += wordLength;
      }
      ans.add(i);
    }
    return ans;
  }
}
