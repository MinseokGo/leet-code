/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return depth;
    }

    private void dfs(TreeNode node, int count) {
        if (node.left != null) {
            dfs(node.left, count + 1);
        }
        if (node.right != null) {
            dfs(node.right, count + 1);
        }
        depth = Math.max(depth, count);
    }
}
