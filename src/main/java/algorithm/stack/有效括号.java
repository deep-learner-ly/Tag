package algorithm.stack;

import java.util.Stack;

/**
 * @author LongyunBian
 * @version 2023/9/26 17:47
 */
public class 有效括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();
                int diff = c- top;
                if(diff!=1 && diff!=2){
                    return false;
                }

            }
        }
        return stack.isEmpty();

    }
}
