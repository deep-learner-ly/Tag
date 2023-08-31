package algorithm.tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/8/31 17:35
 */
public class 中序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode node =root;
        while(!st.isEmpty() || node!=null){
            while(node!=null){

                st.push(node);
                node = node.left;
            }
            node = st.pop();
            res.add(node.val);
            node = node.right;
        }
        return res;

    }
}
