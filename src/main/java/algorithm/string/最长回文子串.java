package algorithm.string;

/**
 * @author LongyunBian
 * @version 2023/9/17 22:12
 */
public class 最长回文子串 {
    public String longestPalindrome(String s) {

        int n= s.length();
        int begin=0, maxLen = 0;
        for(int i=0;i<n;i++){
            int len =0;
            int x = Math.min(i,n-1-i);
            if(maxLen<=2*x+2){
                len = Math.max(expandAroundCenter(s, i, i),expandAroundCenter(s, i, i+1));
            }else{
                continue;
            }

            if(len>maxLen){
                maxLen = len;
                begin = i - ((len - 1)>>1);;
            }


        }
        return s.substring(begin,begin+maxLen);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        return right-left-1;
    }
}
