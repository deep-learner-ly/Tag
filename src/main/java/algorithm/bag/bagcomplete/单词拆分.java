package algorithm.bag.bagcomplete;

import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/9/7 9:33
 */
public class 单词拆分 {
    /**
     * 背包问题解法：
     * 01 背包问题：
     * 如果是 01 背包，即数组中的元素不可重复使用，外循环遍历 arrs，内循环遍历 target，且内循环倒序:
     *
     * 完全背包问题：
     * （1）如果是完全背包，即数组中的元素可重复使用并且不考虑元素之间顺序，arrs 放在外循环（保证 arrs 按顺序），target在内循环。且内循环正序。
     * （2）如果组合问题需考虑元素之间的顺序，需将 target 放在外循环，将 arrs 放在内循环，且内循环正序
     *
     *
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
        // 完全背包
        //  dp[i] 表示以 i 结尾的字符串是否可以被 wordDict 中组合而成。
        boolean [] dp = new boolean [s.length() + 1];
        dp[0] = true;

        for(int i=1;i<=s.length();i++){
            for(String word : wordDict){
                int wordLen = word.length();
                if(i>=wordLen && s.substring(i-wordLen,i).equals(word)){
                    dp[i] = dp[i] || dp[i-wordLen];
                }
            }
        }
        return dp[s.length()];
    }
}
