class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return null;
        }

        else if(root1 == null && root2 != null) {
            TreeNode temp = new TreeNode(root2.val);
            temp.left = mergeTrees(null, root2.left);
            temp.right = mergeTrees(null, root2.right);
            return temp;
        }

        else if(root1 != null && root2 == null) {
            TreeNode temp = new TreeNode(root1.val);
            temp.left = mergeTrees(root1.left, null);
            temp.right = mergeTrees(root1.right, null);
            return temp;
        }

        else {
            TreeNode temp = new TreeNode(root1.val + root2.val);
            temp.left = mergeTrees(root1.left, root2.left);
            temp.right = mergeTrees(root1.right, root2.right);
            return temp;
        }
        
    }
}
