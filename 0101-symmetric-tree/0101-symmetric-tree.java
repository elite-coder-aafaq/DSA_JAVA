class Solution {

    public boolean isMirror(TreeNode left, TreeNode right)
    {
        // Both don't exist → they match
        if(left == null && right == null)
            return true;

        // Only one exists → not symmetric
        if(left == null || right == null)
            return false;

        // Values must be equal
        if(left.val != right.val)
            return false;

        // Cross-check because we need a mirror
        return isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root)
    {
        if(root == null)
            return true;

        return isMirror(root.left, root.right);
    }
}