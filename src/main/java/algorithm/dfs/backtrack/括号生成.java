package algorithm.dfs.backtrack;

import java.util.ArrayList;
import java.util.List;

public class 括号生成 {
    List<String> res = new ArrayList<>();
    StringBuilder sb =new StringBuilder();
    public List<String> generateParenthesis(int n) {
        backtrack(0,0,n);
        return res;
    }

    public void backtrack(int start,int end,int n){
        if(sb.length()==n*2){
            res.add(sb.toString());
            return;
        }
        if(start<n){
            sb.append('(');
            backtrack(start+1,end,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(end<start){
            sb.append(')');
            backtrack(start,end+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
