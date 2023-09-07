package algorithm.dfs.backtrack;

import java.util.*;

/**
 * @author LongyunBian
 * @version 2023/9/7 9:48
 */
public class 单词拆分II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> ans = new ArrayList<>();
        backtrack(s, ans, 0, new LinkedList<>(), set);
        return ans;
    }

    public void backtrack(String s, List<String> ans, int idx, Deque<String> path, Set<String> set) {
        if (idx == s.length()) {
            ans.add(String.join(" ", path));
            return;
        }
        for (int i = idx; i < s.length(); i++) {
            String str = s.substring(idx, i + 1);
            if (set.contains(str)) {
                path.add(str);
                backtrack(s, ans, i + 1, path, set);
                path.removeLast();
            }
        }
    }
}
