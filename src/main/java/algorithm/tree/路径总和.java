package algorithm.tree;

import datastructure.TreeNode;

/**
 * @author LongyunBian
 * @version 2023/9/19 9:58
 */
public class 路径总和 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }
}
