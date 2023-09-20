package algorithm.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author LongyunBian
 * @version 2023/9/20 21:51
 */
public class 逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String token : tokens) {
            if(token.equals("*")){
                st.push(st.pop()*st.pop());
            } else if (token.equals("+")) {
                st.push(st.pop()+st.pop());
            } else if (token.equals("-")) {
                int last = st.pop();
                int first = st.pop();
                st.push(first-last);
            } else if (token.equals("/")) {
                int last = st.pop();
                int first = st.pop();
                st.push(first/last);

            }else {
                st.push(Integer.parseInt(token));
            }
        }
        return st.pop();
    }
}
