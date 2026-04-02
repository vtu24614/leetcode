class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode t1, TreeNode t2) {
        // Case 1: both null
        if (t1 == null && t2 == null) return true;

        // Case 2: one null or values differ
        if (t1 == null || t2 == null || t1.val != t2.val) return false;

        // Case 3: check mirror condition
        return isMirror(t1.left, t2.right) &&
               isMirror(t1.right, t2.left);
    }
}