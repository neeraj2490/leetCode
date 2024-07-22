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
    public int maxDepth(TreeNode root) {

        return maxDepth(root, 0);
    }

    private int maxDepth(TreeNode root, int depth) {

        if(root == null) {
            return depth;
        }

        else {
            int a = maxDepth(root.left, depth + 1);
            int b = maxDepth(root.right, depth + 1);

            return a > b ? a : b;
        }
    }
}
