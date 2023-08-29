package algorithm.tree;

import datastructure.TreeNode;

/**
 * @author LongyunBian
 * @version 2023/8/29 20:41
 */
public class 二叉树中的最大路径和 {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
    private int maxGain(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftGain = Math.max(maxGain(root.left),0);
        int rightGain = Math.max(maxGain(root.right),0);
        int pathSum = leftGain + rightGain + root.val;
        maxSum = Math.max(maxSum,pathSum);
        return root.val + Math.max(leftGain,rightGain);

    }
}
