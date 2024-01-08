package algorithm.dfs.backtrack;

//题目：给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。回文串是正着读和反着读都一样的字符串。
//示例 1：
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]


import java.util.*;
public class 分割回文串 {
    List<List<String>> res=new ArrayList<>();
    public List<List<String>> partition(String s) {
        // Deque<String> path=new ArrayDeque<>();
        //path.addLast(i),path.removeLast()

        List<String> path=new ArrayList<>();
        backtrack(s,0,path);
        return res;
    }

    public void backtrack(String s,int start,List<String> path){
        if(start==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=start;i<s.length();i++){
            String cur=s.substring(start,i+1);
            if(palind(s,start,i)){
                path.add(cur);
            }else{
                continue;
            }
            backtrack(s,i+1,path);
            path.remove(path.size()-1);
        }
    }
    public boolean palind(String s,int start,int end){
        int left=start;
        int right=end;
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
