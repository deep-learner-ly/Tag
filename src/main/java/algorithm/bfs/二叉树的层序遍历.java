package algorithm.bfs;

import datastructure.TreeNode;

import java.util.*;

public class 二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Deque<TreeNode> stack =new LinkedList<>();
        stack.offer(root);
        while(!stack.isEmpty()){
            int qsize= stack.size();
            List<Integer> layer =new ArrayList<>();
            for(int i=1;i<=qsize;i++){
                TreeNode num=stack.poll();
                layer.add(num.val);
                if(num.left!=null){
                    stack.offer(num.left);
                }
                if(num.right!=null){
                    stack.offer(num.right);
                }
            }
            res.add(layer);
        }
        return res;

    }
}
