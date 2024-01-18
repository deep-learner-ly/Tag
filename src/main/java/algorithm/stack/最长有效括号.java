package algorithm.stack;


//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

import java.util.Deque;
import java.util.LinkedList;

public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack=new LinkedList<>();
        int res=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res=Math.max(res,i-stack.peek());
                }

            }

        }
        return res;
    }
}
