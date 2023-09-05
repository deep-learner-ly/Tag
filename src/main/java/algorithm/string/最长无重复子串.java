package algorithm.string;

import java.util.HashMap;

/**
 * @author LongyunBian
 * @version 2023/9/5 23:17
 */
public class 最长无重复子串 {
    public String unDumplateSubstring (String enterString) {
        // write code here
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < enterString.length(); i++) {
            if(map.containsKey(enterString.charAt(i))){
                left = Math.max(left,map.get(enterString.charAt(i))+1);
            }
            map.put(enterString.charAt(i),i);
            if(i-left+1>max){
                max = i-left+1;
                start = left;
            }
        }
        return enterString.substring(start,start+max);
    }
}
