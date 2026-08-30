class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }

    private boolean isValid(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }

        if (((min!=null)&&(node.val <= min.val))||((max!=null)&&(node.val >= max.val)))
         {
            return false;
        }

        return isValid(node.left, min, node) &&
               isValid(node.right, node, max);
    }
}