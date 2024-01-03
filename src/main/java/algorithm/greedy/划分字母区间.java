package algorithm.greedy;


//题目：给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
//注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
//返回一个表示每个字符串片段的长度的列表。

import java.util.*;

public class 划分字母区间 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res=new ArrayList<>();
        int start=0;
        int end=0;

        int[] last=new int[26];
        int n=s.length();
        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        for(int i=0;i<n;i++){
            end=Math.max(end,last[s.charAt(i)-'a']);
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}
