package algorithm.tree;

import datastructure.TreeNode;

/**
 * @author LongyunBian
 * @version 2023/9/7 14:50
 */
public class 二叉树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val) return root;
        if(root.val == q.val) return root;
        TreeNode leftSide = lowestCommonAncestor(root.left, p, q);
        TreeNode rightSide = lowestCommonAncestor(root.right, p, q);
        if(leftSide == null && rightSide == null) return null;
        else if(leftSide == null) return rightSide;
        else if(rightSide == null) return leftSide;
        return root;
    }
}
