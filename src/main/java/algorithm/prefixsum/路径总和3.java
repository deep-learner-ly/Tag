package algorithm.prefixsum;


import datastructure.TreeNode;
import java.util.*;

//题目：给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
public class 路径总和3 {

    //两种方法，DFS，前缀和

    //方法1:DFS,需要特别注意的是类型转换问题，int转换为long型，时间复杂度N2，空间复杂度为N。

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        int res=nodesum(root,targetSum);
        res+=pathSum(root.left,targetSum);
        res+=pathSum(root.right,targetSum);
        return res;
    }

    public int nodesum(TreeNode root,long targetSum){
        int res=0;
        if(root==null) return 0;
        long val=root.val;
        if(val==targetSum){
            res++;
        }
        res+=nodesum(root.left,targetSum-val);
        res+=nodesum(root.right,targetSum-val);

        return res;
    }



    //方法二：前缀和，时间复杂度N，空间复杂度N
    public int pathSum_prefix(TreeNode root, int targetSum) {
        Map<Long,Integer> count_prefix=new HashMap<>();
        count_prefix.put(0L,1);
        Long cur=0L;
        return nodesum_prefix(root,count_prefix,targetSum,cur);
    }

    public int nodesum_prefix(TreeNode root,Map<Long,Integer> count,int targetSum,Long cur){
        if(root==null) return 0;
        int res=0;
        cur+=root.val;

        res+=count.getOrDefault(cur-targetSum,0);
        count.put(cur,count.getOrDefault(cur,0)+1);
        //进入下一层
        res+=nodesum_prefix(root.left,count,targetSum,cur);
        res+=nodesum_prefix(root.right,count,targetSum,cur);
        //回到本层
        count.put(cur,count.get(cur)-1);

        return res;
    }


}
