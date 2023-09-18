package algorithm.tree;

import algorithm.bisearch.搜索插入位置;
import datastructure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author LongyunBian
 * @version 2023/9/18 10:06
 */
public class 恢复二叉搜索树 {
    public void recoverTree(TreeNode root) {

        Deque<TreeNode> st = new LinkedList<>();
        TreeNode x = null, y = null, pred = null;
        while (!st.isEmpty() || root != null) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            System.out.println(root);
            if (pred != null && root.val < pred.val) {
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = root;
            root = root.right;
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
        System.out.println();

    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(7);
//        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(8);
//        new 恢复二叉搜索树().recoverTree(root);
//        System.out.println(root.val);
        int x =1;
        int [] a = {1,2,3};
        new 恢复二叉搜索树().fun(x,a);
        System.out.println(x);
        System.out.println(a[0]);
    }
    private void fun(int x ,int [] a){
        x = 2;
        a[0] = 0;
        a =null;
    }
}
