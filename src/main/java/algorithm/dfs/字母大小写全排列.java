package algorithm.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/8/30 9:18
 */
public class 字母大小写全排列 {
    char[] cs;
    List<String> ans = new ArrayList<>();
    public List<String> letterCasePermutationDFS(String s) {
        cs = s.toCharArray();
        dfs(0,  new char[s.length()]);
        return ans;
    }
    public List<String> letterCasePermutationBT(String s) {
        cs = s.toCharArray();
        backtrace(0);
        return ans;
    }

    private void dfs(int i, char[] chars) {
        if (i == cs.length) {
            ans.add(String.valueOf(chars));
            return ;
        }
        chars[i] = cs[i];
        dfs(i + 1, chars);
        if(Character.isLetter(cs[i])){
            chars[i] = (char) (cs[i]^32);
            dfs(i+1,chars);
        }

    }
    public void backtrace(int i) {
        while (i < cs.length && Character.isDigit(cs[i])) {
            i++;
        }
        if (i == cs.length) {
            ans.add(new String(cs));
            return;
        }
        cs[i] ^= 32;
        backtrace(i + 1);
        cs[i] ^= 32;
        backtrace(i+1);
    }


}
