package algorithm.tree;

//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

import datastructure.TreeNode;

import java.util.*;

public class 从前序与中序遍历序列构造二叉树 {
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(preorder,0,preorder.length-1,0);
    }

    public TreeNode dfs(int[] preorder,int prestart,int prend,int start){
        if(prestart>prend){
            return null;
        }
        int rootval=preorder[prestart];
        TreeNode root=new TreeNode(rootval);
        int index=map.get(rootval);
        int leftindex=index-start;
        root.left=dfs(preorder,prestart+1,prestart+leftindex,start);
        root.right=dfs(preorder,prestart+leftindex+1,prend,index+1);

        return root;
    }
}
