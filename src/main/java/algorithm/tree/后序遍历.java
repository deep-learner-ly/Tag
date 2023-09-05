package algorithm.tree;

import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author LongyunBian
 * @version 2023/8/31 19:42
 */
public class 后序遍历 {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode node =root;
        while(!st.isEmpty() || node!=null){
            while(node!=null){
                res.push(node.val);

                st.push(node);
                node = node.right;
            }
            node = st.pop();
            node = node.left;
        }
        return res;

    }

}
