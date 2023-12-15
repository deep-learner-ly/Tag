package algorithm.bfs;

import datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author LongyunBian
 * @version 2023/11/22 20:48
 */
public class 二叉树的最小深度 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int ans =1;
        while (!queue.isEmpty()) {

            int size = queue.size();
            while(size-->0){
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null) {
                    return ans;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

            }
            ans++;

        }

        return ans;
    }
}
