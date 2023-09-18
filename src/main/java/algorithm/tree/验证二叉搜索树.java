package algorithm.tree;

import datastructure.TreeNode;

/**
 * @author LongyunBian
 * @version 2023/9/18 10:00
 */
public class 验证二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        TreeNode node = root.left;
        while(node!=null){
            if(node.val>=root.val){
                return false;
            }
            node = node.right;
        }
        node = root.right;
        while(node!=null){
            if(node.val<=root.val){
                return false;
            }
            node = node.left;
        }
        return isValidBST(root.left)&&isValidBST(root.right);

    }
}
