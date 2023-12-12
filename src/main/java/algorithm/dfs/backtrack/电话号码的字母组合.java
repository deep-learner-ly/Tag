package algorithm.dfs.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合 {
    List<String> res=new ArrayList<>();
    StringBuilder ss=new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return res;
        Map<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        backtrack(digits,0,map);
        return res;
    }

    public void backtrack(String digits,int k,Map<Character,String> map){
        if(k==digits.length()){
            res.add(ss.toString());
            return;
        }
        char c = digits.charAt(k);
        String letter=map.get(c);
        for(int i=0;i<letter.length();i++){
            ss.append(letter.charAt(i));
            backtrack(digits,k+1,map);
            ss.deleteCharAt(k);

        }

    }
}
