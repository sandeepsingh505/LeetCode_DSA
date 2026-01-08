class Solution {

    public int min(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public int max(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    public boolean helper(TreeNode root) {

        // ✅ empty tree is valid BST
        if (root == null) return true;

        // ✅ check current node with left & right subtree
        if (root.left != null && root.val <= max(root.left))
            return false;

        if (root.right != null && root.val >= min(root.right))
            return false;

        // ✅ recursively check left & right subtree
        return helper(root.left) && helper(root.right);
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root);
    }
}
