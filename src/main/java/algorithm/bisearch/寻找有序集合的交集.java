package algorithm.bisearch;

import utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/9/27 22:19
 */
public class 寻找有序集合的交集 {
    public List<Integer> findCommon(int [] array1,int [] array2){
        if(array1==null||array2==null){
            return null;
        }
        int [] shortArr = array1.length<array2.length?array1:array2;
        int [] longArr = array1.length<array2.length?array2:array1;
        List<Integer> res = new ArrayList<>();
        int start =0;
        for (int i : shortArr) {
            int idx = Utils.biSearchInsert(start,longArr.length-1,longArr,i);
            if(longArr[idx]==i){
                res.add(i);
                start = idx+1;
            }
            else{
                start = idx;
            }
        }
        return res;
    }
    public List<Integer> findCommonPlus(int [] array1,int [] array2){
        if(array1==null||array2==null){
            return null;
        }
        return findCommon(array1,array2,0,array1.length-1,0,array2.length-1);
    }
    public List<Integer> findCommon(int [] array1,int [] array2,int s1,int e1,int s2,int e2){

        List<Integer> res = new ArrayList<>();
        if(s1>e1||s2>e2){
            return res;
        }
        int mid = (s1 + e1)>>1;
        int idx = Utils.biSearchInsert(s2,e2,array2,array1[mid]);
        if(array1[mid] ==array2[idx]){
            res.add(array1[mid]);
            res.addAll(findCommon(array1,array2,s1,mid-1,s1,idx-1));
            res.addAll(findCommon(array1,array2,mid+1,e1,idx+1,e2));
        }else {
            res.addAll(findCommon(array1,array2,s1,mid-1,s1,idx-1));
            res.addAll(findCommon(array1,array2,mid+1,e1,idx,e2));
        }
        return res;

    }
}
