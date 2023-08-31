package algorithm.tree;

import datastructure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/8/31 17:56
 */
public class 先序遍历 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode node =root;
        while(!st.isEmpty() || node!=null){
            while(node!=null){
                res.add(node.val);
                st.push(node);
                node = node.left;
            }
            node = st.pop();
            node = node.right;
        }
        return res;

    }
}
