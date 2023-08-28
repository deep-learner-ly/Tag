package algorithm.prefixsum;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author LongyunBian
 * @version 2023/8/19 16:06
 */
public class 表现良好的最长时间段 {
    public static void main(String[] args) {
        new 表现良好的最长时间段().longestWPI(new int[]{6,6,6});
    }
    public int longestWPI(int[] hours) {
        int n =hours.length;
        int [] s = new int[n+1];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(0);
        for(int i=1;i<=n;i++){
            s[i] = s[i-1] + (hours[i-1]>8?1:-1);
            if(s[st.peek()]>s[i]){
                st.push(i);
            }
        }

        int res = 0;
        for(int r =n;r>=1;r--){
            while(!st.isEmpty() && s[st.peek()]<s[r]){
                res = Math.max(res,r-st.pop());
            }
        }
        return res;
    }

}
