package algorithm.tree;

import datastructure.TreeNode;

/**
 * @author LongyunBian
 * @version 2023/9/6 22:21
 */
public class 二叉搜索树中第K小的元素 {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return -1;
        }

        int l = kthSmallest(root.left,k);
        if(l<0){
            count++;
            if(count == k){
                return root.val;
            }
            int r = kthSmallest(root.right,k);
            return r;
        }
        return l;
    }
}
