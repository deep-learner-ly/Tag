package algorithm.bfs;

import datastructure.TreeNode;

import java.util.*;


//s思路是，采用层序遍历的方法，将每层的最后一个元素加入到结果中，参考二叉树的层序遍历，力扣102题
public class 二叉树的右视图 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Deque<TreeNode> stack=new LinkedList<>();
        stack.offer(root);
        while(!stack.isEmpty()){
            int num =stack.size();
            for(int i=0;i<num;i++){
                TreeNode node = stack.poll();
                if(node.left!=null){
                    stack.offer(node.left);
                }
                if(node.right!=null){
                    stack.offer(node.right);
                }
                if(i==num-1) res.add(node.val);
            }
        }

        return res;

    }
}
