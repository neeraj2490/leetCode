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
    public int minDepth(TreeNode root) {
        return minDepth(root, 0);
    }

    private int minDepth(TreeNode root, int depth) {

        if(root == null) {
            return depth;
        }

        if(root.left == null && root.right == null) {
            return depth + 1;
        }

        else {
            int a = root.left != null 
                ? minDepth(root.left, depth +1) 
                : Integer.MAX_VALUE;
            
            int b = root.right != null 
                ? minDepth(root.right, depth +1)
                : Integer.MAX_VALUE;

            return a < b ? a : b;
        }
    }
}
